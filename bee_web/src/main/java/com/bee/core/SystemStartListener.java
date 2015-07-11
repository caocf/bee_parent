package com.bee.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by suntongwei on 15/6/19.
 */
public class SystemStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserCacheFactory.getInstance();
        ShopCacheFactory.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
