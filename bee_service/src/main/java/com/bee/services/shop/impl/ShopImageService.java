package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopImageDao;
import com.bee.services.shop.IShopImageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public class ShopImageService implements IShopImageService {

    @Autowired
    protected ShopImageDao shopImageDao;
}
