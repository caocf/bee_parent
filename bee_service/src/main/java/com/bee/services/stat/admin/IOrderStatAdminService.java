package com.bee.services.stat.admin;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IOrderStatAdminService {

    /**
     * 统计全部完成订单
     *
     * @param shopId 如果是0，则代表统计全部商户
     * @return
     */
    Double[] statFinishOrder(long shopId, int number, long time);
}
