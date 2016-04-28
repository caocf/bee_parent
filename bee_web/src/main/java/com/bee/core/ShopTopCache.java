package com.bee.core;

import com.bee.services.shop.IShopService;
import com.bee.services.shop.impl.ShopService;
import com.qsd.framework.spring.SpringFactory;

/**
 * Created by suntongwei on 15/8/23.
 */
public class ShopTopCache {

    /**
     * 商家接口
     */
    private IShopService shopService = SpringFactory.getBean(ShopService.class);


    /**
     * 初始化方法
     */
    private void _init() {
        shopService.queryRecommendShop();
    }

    private static ShopTopCache ourInstance = new ShopTopCache();
    public static ShopTopCache getInstance() {
        return ourInstance;
    }
    private ShopTopCache() {
        _init();
    }
}
