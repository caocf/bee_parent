package com.bee.services.system.impl;

import com.bee.dao.SystemConfigDao;
import com.bee.pojo.SystemConfig;
import com.bee.services.system.ISystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/12/25.
 */
@Service
public class SystemConfigService implements ISystemConfigService {

    @Autowired
    protected SystemConfigDao systemConfigDao;

    @Override
    public List<SystemConfig> getConfigAll() {
        return systemConfigDao.getSystemConfigAll();
    }

    @Override
    public SystemConfig getConfig(int type) {
        return systemConfigDao.getSystemConfig(type);
    }

    @Override
    @Transactional
    public void setConfig(SystemConfig systemConfig) {
        systemConfigDao.update(systemConfig);
    }
}
