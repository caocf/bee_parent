package com.bee.app.commons;

import com.bee.pojo.SystemConfig;
import com.bee.services.system.ISystemConfigService;
import com.bee.services.system.impl.SystemConfigService;
import com.qsd.framework.spring.SpringFactory;

import java.util.List;

/**
 * Created by suntongwei on 15/12/25.
 */
public class SystemConfigFactory {

    // service
    private ISystemConfigService systemConfigService;

    // 系统配置
    private List<SystemConfig> systemConfigList;

    /**
     *
     * @return
     */
    public SystemConfig getConfig(int type) {
        for (SystemConfig config : systemConfigList) {
            if (config.getType() == type) {
                return config;
            }
        }
        return null;
    }

    public void setConfig(SystemConfig systemConfig) {
        for (SystemConfig config : systemConfigList) {
            if (config.getType() == systemConfig.getType()) {
                config.setFlag(systemConfig.getFlag());
                systemConfigService.setConfig(config);
            }
        }
    }

    private void init() {
        systemConfigService = SpringFactory.getBean(SystemConfigService.class);
        systemConfigList = systemConfigService.getConfigAll();
    }

    private static SystemConfigFactory ourInstance = new SystemConfigFactory();
    public static SystemConfigFactory getInstance() {
        return ourInstance;
    }
    private SystemConfigFactory() {
        init();
    }
}
