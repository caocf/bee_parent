package com.bee.dao;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Applyer;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/27.
 */
@Repository
public class ApplyerDao extends JpaDaoSupport<Applyer, Long> {

    /**
     * 查询商家申请列表
     *
     * @param param
     * @return
     */
    public PagingResult<Applyer> queryApplyerList(AdminRequestPaging param) {
        HQLEntity entity = new HQLEntity();
        entity.setEntity("From Applyer A order by A.aid desc");
        entity.setPaging(param);
        return queryWithPaging(entity);
    }
}
