package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopPriceDao;
import com.bee.services.shop.IShopPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopPriceService implements IShopPriceService {

    @Autowired
    private ShopPriceDao shopPriceDao;
}
