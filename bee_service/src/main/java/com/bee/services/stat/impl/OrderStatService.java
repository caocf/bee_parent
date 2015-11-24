package com.bee.services.stat.impl;

import com.bee.dao.order.OrderDao;
import com.bee.services.stat.IOrderStatService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class OrderStatService implements IOrderStatService {

    @Autowired
    protected OrderDao orderDao;
}
