package com.bee.dao;

import com.bee.commons.SQL;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.AppVer;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@Repository
public class AppVerDao extends JpaDaoSupport<AppVer, Long> {

    public static final String QueryAppVerList = "From AppVer A order by A.avid desc";

    /**
     * 查询版本列表
     *
     * @param params
     * @return
     */
    public PagingResult<AppVer> queryAppVerList(AdminRequestPaging params) {
        HQLEntity entity = new HQLEntity(QueryAppVerList);
        entity.setPaging(params);
        return queryWithPaging(entity);
    }

    public List<AppVer> getAppVerList() {
        return findByParams(SQL.AppVer.getAppVerList);
    }

    public AppVer getNewAppVer(int phoneType) {
        return findFirstByParams(SQL.AppVer.getNewAppVer, phoneType);
    }
}
