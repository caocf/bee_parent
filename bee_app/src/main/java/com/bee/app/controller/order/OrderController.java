package com.bee.app.controller.order;

import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.domain.params.order.OrderListParam;
import com.bee.services.order.app.IOrderAppService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/11/25.
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private IOrderAppService orderAppService;

    /**
     * 查询订单列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<OrderListItem> index(OrderListParam param) {
        PagingResult<OrderListItem> items = orderAppService.getAppOrderListByParam(param);
        items.setMaxRows(param.getMaxRows());
        return items;
    }

    /**
     * 查询订单信息
     * 主要用于查看订单时，实时更新订单状态等订单信息
     *
     * @return oid 订单ID
     */
    @RequestMapping(value = "/{oid}", method = RequestMethod.GET)
    public OrderItem queryOrder(@PathVariable Long oid) {
        return orderAppService.queryOrderItemById(oid);
    }
}
