package com.bee.admin.system;

import com.bee.services.ticket.admin.IUserTicketAdminService;
import com.bee.services.ticket.admin.impl.UserTicketAdminService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.spring.SpringFactory;

import java.util.Calendar;

/**
 * 维护红包优惠券过期
 *
 * Created by suntongwei on 16/1/4.
 */
public class MateTicketExpiredThread implements Runnable {

    private Calendar calendar;

    private IUserTicketAdminService userTicketAdminService;

    public MateTicketExpiredThread() {
        System.out.println("启动用户优惠券红包维护线程");
        userTicketAdminService = SpringFactory.getBean(UserTicketAdminService.class);
    }

    @Override
    public void run() {

        calendar = Calendar.getInstance();

        // 获取下个维护时间
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 0) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        try {

            // 等待
            long waitTime = calendar.getTimeInMillis() - System.currentTimeMillis();
            System.out.println("用户优惠券红包过期维护线程将在: " + waitTime + "毫秒后执行");
            Thread.sleep(waitTime);

            while (true) {
                userTicketAdminService.mateUserTicket();
                Thread.sleep(DateUtil.ONE_DAY_TIME);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("MateTicketExpiredThread Exception.");
        }

    }
}
