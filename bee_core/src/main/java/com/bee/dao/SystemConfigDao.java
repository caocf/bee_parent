package com.bee.dao;

import com.bee.commons.SQL;
import com.bee.pojo.SystemConfig;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/12/25.
 */
@Repository
public class SystemConfigDao extends JpaDaoSupport<SystemConfig, Long> {

    /**
     * 获取配置信息
     *
     * @param type
     * @return
     */
    public SystemConfig getSystemConfig(int type) {
        return findFirstByParams(SQL.SystemConfig.GetSystemConfig, type);
    }

}
