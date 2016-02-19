package com.bee.services.shop;

import com.bee.pojo.shop.ShopUpdate;

/**
 * Created by suntongwei on 16/2/17.
 */
public interface IShopUpdateService {

    /**
     * 获取ShopUpdate
     *
     * @param shopId
     * @return
     */
    ShopUpdate getShopUpdateByShopId(Long shopId);

    /**
     * 更新ShopUpdate
     *
     * @param shopUpdate
     */
    void updateShopUpdate(ShopUpdate shopUpdate);
}
