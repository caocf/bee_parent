package com.bee.services.stat.busi.impl;

import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.services.stat.busi.IOrderStatBusiService;
import com.bee.services.stat.impl.OrderStatService;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class OrderStatBusiService extends OrderStatService implements IOrderStatBusiService {

    /**
     *
     * @param shopId 商家ID
     * @return
     */
    @Override
    public BusiOrderNumberStat queryOrderNumberStat(long shopId) {
        return orderDao.queryBusiOrderNumberStat(shopId);
    }
}
