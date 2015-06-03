package com.bee.services.order;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.client.params.order.OrderListRequest;
import com.bee.modal.OrderListItem;
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
     * 根据参数查询订单
     *
     * @param request
     * @return
     */
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListRequest request);

    /**
     * 创建订单
     *
     * @param order
     * @throws DataRunException
     */
    public void createOrder(Order order) throws DataRunException;

    /**
     * 接受订单
     *
     * @param id
     * @throws DataRunException
     */
    public void acceptOrder(long id) throws DataRunException;

    /**
     * 取消订单
     *
     * @param id
     * @param status
     * @throws DataRunException
     */
    public void cancelOrder(long id, int status) throws DataRunException;

    /**
     * 完成订单
     *
     * @param id
     * @throws DataRunException
     */
    public void finishOrder(long id) throws DataRunException;
}
