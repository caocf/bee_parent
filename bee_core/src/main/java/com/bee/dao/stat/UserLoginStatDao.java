package com.bee.dao.stat;

import com.bee.admin.params.stat.QueryUserLoginStatParam;
import com.bee.commons.SQL;
import com.bee.pojo.stat.UserLoginStat;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/28.
 */
@Repository
public class UserLoginStatDao extends JpaDaoSupport<UserLoginStat, Long> {

    /**
     *
     * @param param
     * @return
     */
    public List<UserLoginStat> queryUserLoginStatByParam(QueryUserLoginStatParam param) {

        // HQLEntity
        HQLEntity entity = new HQLEntity();

        // HQL
        StringBuffer sb = new StringBuffer(SQL.Stat.QueryUserLoginStatByParam);

        // 组装参数
        if (param != null) {
            if (param.getStartCreateTime() != null) {
                sb.append(" and A.createTime >= ?");
                entity.setParams(param.getStartCreateTime());
            }
            if (param.getEndCreateTime() != null) {
                sb.append(" and A.createTime < ?");
                entity.setParams(param.getEndCreateTime());
            }

            if (!StringUtil.isNull(param.getSortSection())) {
                sb.append(" ORDER BY ");
                sb.append(param.getSortSection());
            }
        }

        entity.setEntity(sb);

        return queryResult(entity);
    }

    /**
     * 查询用户登录统计，获取每天新设备号的登录
     *
     * @param param
     * @return
     */
    public List<UserLoginStat> queryUserLoginStatNewDevice(QueryUserLoginStatParam param) {
        // HQLEntity
        HQLEntity entity = new HQLEntity();

        // HQL
        StringBuffer sb = new StringBuffer(SQL.Stat.QueryUserLoginStatByParam);

        // 组装参数
        if (param != null) {
            if (param.getStartCreateTime() != null) {
                sb.append(" and A.createTime >= ?");
                entity.setParams(param.getStartCreateTime());
            }

            // 对device增加设备
            sb.append(" GROUP BY A.device");

            if (!StringUtil.isNull(param.getSortSection())) {
                sb.append(" ORDER BY ");
                sb.append(param.getSortSection());
            }
        }

        entity.setEntity(sb);

        return queryResult(entity);
    }

}
