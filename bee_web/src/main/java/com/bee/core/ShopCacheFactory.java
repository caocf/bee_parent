package com.bee.core;

/**
 * Created by suntongwei on 15/6/19.
 */
public class ShopCacheFactory {


    private static ShopCacheFactory ourInstance = new ShopCacheFactory();
    public static ShopCacheFactory getInstance() {
        return ourInstance;
    }
    private ShopCacheFactory() {
    }
}
