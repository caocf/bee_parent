package com.bee.dao;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Advice;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/24.
 */
@Repository
public class AdviceDao extends JpaDaoSupport<Advice, Long> {

    public static final String QueryUserAdvice = "From Advice A left join fetch A.user B order by A.aid desc";

    /**
     * 查询用户建议
     *
     * @param params
     * @return
     */
    public PagingResult<Advice> queryUserAdvice(AdminRequestPaging params) {
        HQLEntity entity = new HQLEntity(QueryUserAdvice);
        entity.setPaging(params);
        return queryWithPaging(entity);
    }

}
