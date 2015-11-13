package com.bee.admin.services.stat;

import com.bee.busi.model.order.BusiOrderNumberStat;

/**
 * Created by suntongwei on 15/10/7.
 */
public interface IOrderStatService {

    /**
     * 统计全部完成订单
     *
     * @param shopId 如果是0，则代表统计全部商户
     * @return
     */
    public Double[] statFinishOrder(long shopId, int number, long time);

}
