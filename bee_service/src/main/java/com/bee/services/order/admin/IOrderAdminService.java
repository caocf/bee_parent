package com.bee.services.order.admin;

import com.bee.domain.params.order.AdminOrderParam;
import com.bee.pojo.order.Order;
import com.bee.services.order.IOrderService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IOrderAdminService extends IOrderService {

    /**
     * 根据参数查询订单列表
     *
     * @param request
     * @return
     */
    PagingResult<Order> getOrderListByParam(AdminOrderParam request);

    /**
     * 查询订单详细
     *
     * @param orderId
     * @return
     */
    Order getOrderDetailByOid(Long orderId);
}
