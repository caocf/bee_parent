package com.bee.services.stat.impl;

import com.bee.dao.stat.ShopStatDao;
import com.bee.services.stat.IShopStatService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 16/5/4.
 */
public abstract class ShopStatService implements IShopStatService {

    @Autowired
    protected ShopStatDao shopStatDao;
}
