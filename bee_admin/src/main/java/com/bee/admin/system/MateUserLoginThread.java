package com.bee.admin.system;

import com.qsd.framework.commons.utils.DateUtil;

import java.util.Calendar;

/**
 * 维护用户登录线程
 *
 * Created by suntongwei on 15/12/31.
 */
public class MateUserLoginThread implements Runnable {

    private Calendar calendar;


    public MateUserLoginThread() {
        System.out.println("启动维护用户登录表线程");
    }


    @Override
    public void run() {

        calendar = Calendar.getInstance();

        // 获取下个维护时间
        if (calendar.get(Calendar.HOUR_OF_DAY) > 3) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        try {

            // 等待
            long waitTime = calendar.getTimeInMillis() - System.currentTimeMillis();
            System.out.println("用户登录表维护线程将在: " + waitTime + "毫秒后执行");
            Thread.sleep(waitTime);

            while (true) {



                Thread.sleep(DateUtil.ONE_DAY_TIME);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
