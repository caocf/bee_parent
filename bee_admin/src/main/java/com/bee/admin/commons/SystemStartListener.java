package com.bee.admin.commons;

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
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
