package com.bee.services.order.impl;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.client.params.order.OrderCreateRequest;
import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Consts;
import com.bee.dao.order.OrderDao;
import com.bee.modal.OrderListItem;
import com.bee.pojo.order.Order;
import com.bee.pojo.user.User;
import com.bee.services.order.IOrderService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/4/24.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request) {
        return orderDao.getOrderListByParam(request);
    }

    @Override
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListRequest request) {
        return orderDao.getAppOrderListByParam(request);
    }

    @Deprecated
    @Override
    @Transactional
    public void createOrder(OrderCreateRequest req) throws DataRunException {

        try {

            // 添加订单类型, 该字段无效
            req.getOrder().setType(Consts.Order.Type.Master);
            // 添加订单创建时间
            req.getOrder().setCreateTime(System.currentTimeMillis());
            // 设置订单初始化状态
            req.getOrder().setStatus(Consts.Order.Status.Create);

            // 保存订单
            orderDao.save(req.getOrder());

        } catch (DataRunException e) {
            throw e;
        }
    }

    /**
     * 创建订单
     *
     * @param order
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void createOrder(Order order) throws DataRunException {
        // 添加订单类型, 该字段无效
        order.setType(Consts.Order.Type.Master);
        // 添加订单创建时间
        order.setCreateTime(System.currentTimeMillis());
        // 设置订单初始化状态
        order.setStatus(Consts.Order.Status.Create);
    }

    @Override
    @Transactional
    public void acceptOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(Consts.Order.Status.Underway);
        orderDao.update(order);
    }

    @Override
    @Transactional
    public void cancelOrder(long id, int status) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(status);
        orderDao.update(order);
    }

    @Override
    @Transactional
    public void finishOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(Consts.Order.Status.Finish);
        orderDao.update(order);
    }
}
