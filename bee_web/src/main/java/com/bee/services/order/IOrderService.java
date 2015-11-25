package com.bee.services.order;

import com.bee.client.params.order.OrderCreateRequest;
import com.bee.client.params.order.OrderListRequest;
import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.pojo.order.Order;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/4/24.
 */
public interface IOrderService {

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
     * 修改订单人数
     *
     * @param oid 订单ID
     * @param num 新人数
     * @throws DataRunException
     */
    public void editOrderNum(long oid, int num) throws DataRunException;

    /**
     * 【C端】用户取消订单
     *
     * @param id
     * @param status
     * @throws DataRunException
     */
    public void cancelOrder(long id, int status) throws DataRunException;

    /**
     * 查询订单
     *
     * @param oid
     */
    public OrderItem getOrderByOid(long oid);

}
