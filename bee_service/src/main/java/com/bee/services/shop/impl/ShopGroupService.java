package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopGroupDao;
import com.bee.services.shop.IShopGroupService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopGroupService implements IShopGroupService {

    @Autowired
    protected ShopGroupDao shopGroupDao;
}
