package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopConfigDao;
import com.bee.services.shop.IShopConfigService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 16/4/23.
 */
public abstract class ShopConfigService implements IShopConfigService {

    @Autowired
    protected ShopConfigDao shopConfigDao;
}
