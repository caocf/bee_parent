package com.bee.services.system;

import com.bee.pojo.SystemConfig;

import java.util.List;

/**
 * Created by suntongwei on 15/12/25.
 */
public interface ISystemConfigService {

    /**
     * 获取所有配置信息
     *
     * @return
     */
    List<SystemConfig> getConfigAll();

    /**
     * 获取配置
     *
     * @param type
     * @return
     */
    SystemConfig getConfig(int type);

    /**
     * 设置配置
     *
     * @param systemConfig
     */
    void setConfig(SystemConfig systemConfig);
}
