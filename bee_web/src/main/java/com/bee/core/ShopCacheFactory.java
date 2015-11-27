package com.bee.core;

import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.bee.services.shop.impl.ShopService;
import com.qsd.framework.spring.SpringFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by suntongwei on 15/6/19.
 */
public class ShopCacheFactory {

    /**
     * 商家接口
     */
    private IShopService shopService = SpringFactory.getBean(ShopService.class);

    /**
     * 商家缓存
     */
    private Map<Long, Shop> cache = new ConcurrentHashMap();





    /**
     * 放入商家缓存
     *
     * @param shop
     */
    public void put(Shop shop) {
        cache.put(shop.getSid(), shop);
    }

    /**
     * 获取商家缓存
     *
     * @param sid
     * @return
     */
    public Shop get(Long sid) {
        return cache.get(sid);
    }

    /**
     * 从缓存中删除
     *
     * @param sid
     */
    public void remove(Long sid) {
        if (cache.containsKey(sid)) {
            cache.remove(sid);
        }
    }

    /**
     *
     */
    public void clear() {
        cache.clear();
    }

    /**
     * 初始化
     */
    private void _init() {
//        Log.debug("启动初始化商家缓存机制...");
//        List<Shop> shops = shopService.getShopAll();
//        for (Shop shop : shops) {
//            cache.put(shop.getSid(), shop);
//        }
//        Log.debug("成功缓存商家数: " + cache.size());
    }

    private static ShopCacheFactory ourInstance = new ShopCacheFactory();
    public static ShopCacheFactory getInstance() {
        return ourInstance;
    }
    private ShopCacheFactory() {
        _init();
    }
}
