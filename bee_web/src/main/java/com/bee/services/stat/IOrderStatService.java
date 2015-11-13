package com.bee.services.stat;

import com.bee.busi.model.order.BusiOrderNumberStat;

/**
 * Created by suntongwei on 15/11/11.
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
