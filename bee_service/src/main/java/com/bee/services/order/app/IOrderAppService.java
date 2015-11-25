package com.bee.services.order.app;

import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.domain.params.order.OrderListParam;
import com.bee.services.order.IOrderService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/25.
 */
public interface IOrderAppService extends IOrderService {


    /**
     * 根据参数查询订单
     *
     * @param request
     * @return
     */
    PagingResult<OrderListItem> getAppOrderListByParam(OrderListParam request);

    /**
     * 根据订单ID查询订单
     * 主要用于显示订单详细
     *
     * @param orderId
     * @return
     */
    OrderItem queryOrderItemById(long orderId);
}
