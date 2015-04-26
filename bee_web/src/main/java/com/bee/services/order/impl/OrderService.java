package com.bee.services.order.impl;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.commons.Consts;
import com.bee.dao.order.OrderDao;
import com.bee.pojo.order.Order;
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
    @Transactional
    public void createOrder(Order order) throws DataRunException {
        order.setCreateTime(System.currentTimeMillis());
        order.setStatus(Consts.Order.Status.Execute);
        orderDao.save(order);
    }

    @Override
    @Transactional
    public void cancelOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        order.setStatus(Consts.Order.Status.Cancel);
        orderDao.update(order);
    }
}
