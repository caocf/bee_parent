package com.bee.services.stat.impl;

import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.dao.order.OrderDao;
import com.bee.services.stat.IOrderStatService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/10/7.
 */
@Service
public class OrderStatService implements IOrderStatService {

    @Autowired
    private OrderDao orderDao;

    /**
     *
     * @param shopId 商家ID
     * @return
     */
    @Override
    public BusiOrderNumberStat queryBusiOrderNumberStat(long shopId) {
        return orderDao.queryBusiOrderNumberStat(shopId);
    }
}
