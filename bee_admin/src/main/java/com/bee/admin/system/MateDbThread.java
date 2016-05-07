package com.bee.admin.system;

import com.bee.services.stat.admin.IShopStatAdminService;
import com.bee.services.stat.admin.IUserStatAdminService;
import com.bee.services.stat.admin.impl.ShopStatAdminService;
import com.bee.services.stat.admin.impl.UserStatAdminService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.spring.SpringFactory;

import java.util.Calendar;

/**
 * Created by suntongwei on 16/5/7.
 */
public class MateDbThread implements Runnable {

    // Calendar
    private Calendar calendar;

    private static final long DAY30 = DateUtil.ONE_DAY_TIME * 30;

    // IShopStatAdminService
    private IShopStatAdminService shopStatAdminService;
    // IUserStatAdminService
    private IUserStatAdminService userStatAdminService;

    public MateDbThread() {
        System.out.println("启动数据库维护线程");
        shopStatAdminService = SpringFactory.getBean(ShopStatAdminService.class);
        userStatAdminService = SpringFactory.getBean(UserStatAdminService.class);
    }

    @Override
    public void run() {

        calendar = Calendar.getInstance();

        // 获取下个维护时间
        if (calendar.get(Calendar.HOUR_OF_DAY) >= 4) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        try {

            // 等待
            long waitTime = calendar.getTimeInMillis() - System.currentTimeMillis();
            System.out.println("数据库维护线程将在: " + waitTime + "毫秒后执行");
            System.out.println(DateUtil.formatDateTime(calendar.getTimeInMillis()));
            Thread.sleep(waitTime);

            long mateTime = 0;

            while (true) {
                mateTime = System.currentTimeMillis() - DAY30;
                System.out.println("开始清理商家统计表");
                shopStatAdminService.mateShopStat(mateTime);
                System.out.println("开始清理用户登录统计表");
                userStatAdminService.mateUserLogin(mateTime);
                Thread.sleep(DateUtil.ONE_DAY_TIME);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("MateTicketExpiredThread Exception.");
        }
    }
}
