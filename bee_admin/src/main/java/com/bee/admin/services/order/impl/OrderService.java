package com.bee.admin.services.order.impl;

import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.dao.order.OrderDao;
import com.bee.pojo.order.Order;
import com.bee.admin.services.order.IOrderService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/7.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;


    /**
     *
     * @param request
     * @return
     */
    @Override
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request) {
        return orderDao.getOrderListByParam(request);
    }
}
