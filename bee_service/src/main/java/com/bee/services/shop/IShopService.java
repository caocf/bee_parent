package com.bee.services.shop;

import com.bee.pojo.shop.Shop;
import com.qsd.framework.hibernate.exception.DataRunException;

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

    /**
     * 更新商家信息
     *
     * @param shop
     */
    void update(Shop shop) throws DataRunException;
}
