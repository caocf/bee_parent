package com.bee.services.order;

import com.bee.app.model.order.OrderItem;
import com.bee.busi.model.order.BusiOrderItem;
import com.bee.busi.model.order.BusiOrderListItem;
import com.bee.busi.params.order.BusiOrderListRequest;
import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.client.params.order.OrderCreateRequest;
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
     * 根据参数查询订单
     *
     * @param request
     * @return
     */
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListRequest request);

    /**
     * 创建订单
     *
     * @param req
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    public void createOrder(OrderCreateRequest req) throws DataRunException;

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
     * 完成订单
     *
     * @param id
     * @throws DataRunException
     */
    public void finishOrder(long id) throws DataRunException;

    /**
     * 【C端】用户取消订单
     *
     * @param id
     * @param status
     * @throws DataRunException
     */
    public void cancelOrder(long id, int status) throws DataRunException;

    /**
     * 【B端】商户取消订单
     *
     * @param id
     * @throws DataRunException
     */
    public void cancelBusiOrder(long id) throws DataRunException;

    /**
     * 【B端】商家拒绝订单
     *
     * @param id
     * @throws DataRunException
     */
    public void rejectOrder(long id) throws DataRunException;

    /**
     * 查询订单
     *
     * @param oid
     */
    public OrderItem getOrderByOid(long oid);

    /**
     * 根据参数查询商户端订单列表
     *
     * @param request
     * @return
     */
    public List<BusiOrderListItem> getBusiOrderListByParam(BusiOrderListRequest request);

    /**
     * 根据订单ID查询商户端订单详细
     *
     * @return
     */
    public BusiOrderItem getBusiOrderItem(long oid);

    /**
     * 接受订单
     *
     * @param id
     * @throws DataRunException
     */
    public void acceptOrder(long id) throws DataRunException;
}
