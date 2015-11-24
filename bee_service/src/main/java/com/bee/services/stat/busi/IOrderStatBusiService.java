package com.bee.services.stat.busi;

import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.services.stat.IOrderStatService;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IOrderStatBusiService extends IOrderStatService {

    /**
     * 查询B端订单统计
     *
     * @param shopId 商家ID
     * @return
     */
    BusiOrderNumberStat queryOrderNumberStat(long shopId);
}
