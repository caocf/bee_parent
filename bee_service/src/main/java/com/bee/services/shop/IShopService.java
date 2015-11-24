package com.bee.services.shop;

import com.bee.pojo.shop.Shop;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopService {


    /**
     * 查询一个商家信息
     *
     * @param sid
     * @return
     */
    Shop getShopById(long sid);
}
