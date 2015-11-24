package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopTecheeDao;
import com.bee.services.shop.IShopTecheeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopTecheeService implements IShopTecheeService {

    @Autowired
    protected ShopTecheeDao shopTecheeDao;
}
