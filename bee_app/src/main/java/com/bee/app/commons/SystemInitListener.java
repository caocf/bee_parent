package com.bee.app.commons;

import com.bee.sms.SMSCodeFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 系统初始化监听器
 *
 * Created by suntongwei on 15/12/21.
 */
public class SystemInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("初始化短信验证码工厂...");
        SMSCodeFactory.getInstance();
        System.out.println("初始化系统配置...");
        SystemConfigFactory.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
