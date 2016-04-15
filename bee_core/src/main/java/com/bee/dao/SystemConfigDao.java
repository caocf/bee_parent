package com.bee.dao;

import com.bee.commons.SQL;
import com.bee.pojo.SystemConfig;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return findFirstConverByParams(SQL.SystemConfig.GetSystemConfig, SystemConfigConver, type);
    }
    public static final QueryDataConver<SystemConfig> SystemConfigConver = new QueryDataConver<SystemConfig>() {
        @Override
        public SystemConfig converData(Object[] row) {
            SystemConfig item = new SystemConfig();
            item.setScId(NumberUtil.parseLong(row[0], 0));
            item.setType(NumberUtil.parseInteger(row[1], 0));
            item.setFlag(NumberUtil.parseLong(row[2], 0));
            return item;
        }
    };


    public List<SystemConfig> getSystemConfigAll() {
        return findConverByParams(SQL.SystemConfig.GetSystemConfigAll, SystemConfigConver);
    }
}
