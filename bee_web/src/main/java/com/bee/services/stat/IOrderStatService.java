package com.bee.services.stat;

import com.bee.busi.model.order.BusiOrderNumberStat;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/10/7.
 */
public interface IOrderStatService {

    /**
     * 查询B端订单统计
     *
     * @param shopId 商家ID
     * @return
     */
    public BusiOrderNumberStat queryBusiOrderNumberStat(long shopId);
}