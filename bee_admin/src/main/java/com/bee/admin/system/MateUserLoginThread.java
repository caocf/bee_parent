package com.bee.admin.system;

import java.util.Calendar;

/**
 * 维护用户登录线程
 *
 * Created by suntongwei on 15/12/31.
 */
public class MateUserLoginThread implements Runnable {

    private Calendar calendar;


    public MateUserLoginThread() {
        calendar = Calendar.getInstance();

        // 获取下个维护时间
    }


    @Override
    public void run() {
        System.out.println("启动维护用户登录表线程");
        while (true) {




        }
    }
}
