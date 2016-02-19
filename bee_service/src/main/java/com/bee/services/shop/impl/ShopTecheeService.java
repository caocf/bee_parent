package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopTecheeDao;
import com.bee.dao.shop.ShopUpdateDao;
import com.bee.pojo.shop.ShopUpdate;
import com.bee.services.shop.IShopTecheeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopTecheeService implements IShopTecheeService {

    @Autowired
    protected ShopTecheeDao shopTecheeDao;
    @Autowired
    protected ShopUpdateDao shopUpdateDao;

    /**
     * 当商家技师信息发生改变
     */
    protected void changeShopTechee(Long shopId) {
        ShopUpdate shopUpdate = shopUpdateDao.getShopUpdateByShopId(shopId);
        if (null == shopUpdate) {
            shopUpdate = shopUpdateDao.create(shopId);
        }
        shopUpdate.setUpdateTechee(System.currentTimeMillis());
        shopUpdateDao.update(shopUpdate);
    }
}
