package com.bee.services.order.impl;

import com.bee.dao.order.OrderDao;
import com.bee.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class OrderService implements IOrderService {

    @Autowired
    protected OrderDao orderDao;
}
