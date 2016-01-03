package com.bee.admin.commons;

import com.bee.admin.system.MateTicketExpiredThread;
import com.bee.admin.system.MateUserLoginThread;
import com.bee.sms.SMSCodeFactory;
import com.qsd.framework.security.config.SecurityConfiguration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by suntongwei on 15/11/8.
 */
public class SystemStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SecurityConfiguration.getInstance().setDebug(AdminConsts.isDebug);
        SMSCodeFactory.getInstance();

        // 启动维护线程
        new Thread(new MateUserLoginThread()).start();
        // 启动红包优惠券过期维护线程
        new Thread(new MateTicketExpiredThread()).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
