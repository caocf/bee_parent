package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopFocusDao;
import com.bee.services.shop.IShopFocusService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/17.
 */
public abstract class ShopFocusService implements IShopFocusService {

    @Autowired
    protected ShopFocusDao shopFocusDao;
}
