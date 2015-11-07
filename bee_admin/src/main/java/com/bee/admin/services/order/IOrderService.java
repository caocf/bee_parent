package com.bee.admin.services.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.pojo.order.Order;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/7.
 */
public interface IOrderService {

    /**
     * 根据参数查询订单列表
     *
     * @param request
     * @return
     */
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request);




}
