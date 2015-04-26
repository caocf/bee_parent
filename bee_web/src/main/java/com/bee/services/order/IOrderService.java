package com.bee.services.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.pojo.order.Order;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

import java.util.List;

/**
 * Created by suntongwei on 15/4/24.
 */
public interface IOrderService {

    /**
     * 根据参数查询订单列表
     *
     * @param request
     * @return
     */
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request);

    /**
     * 创建订单
     *
     * @param order
     * @throws DataRunException
     */
    public void createOrder(Order order) throws DataRunException;

    /**
     * 取消订单
     *
     * @param id
     * @throws DataRunException
     */
    public void cancelOrder(long id) throws DataRunException;
}
