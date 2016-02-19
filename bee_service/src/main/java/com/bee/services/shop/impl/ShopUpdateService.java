package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopUpdateDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopUpdate;
import com.bee.services.shop.IShopUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 16/2/17.
 */
@Service
public class ShopUpdateService implements IShopUpdateService {

    @Autowired
    protected ShopUpdateDao shopUpdateDao;

    /**
     *
     * @param shopId
     * @return
     */
    @Override
    @Transactional
    public ShopUpdate getShopUpdateByShopId(Long shopId) {
        ShopUpdate shopUpdate = shopUpdateDao.getShopUpdateByShopId(shopId);
        if (null == shopUpdate) {
            shopUpdate = shopUpdateDao.create(shopId);
        }
        return shopUpdate;
    }

    /**
     * 更新ShopUpdate
     *
     * @param shopUpdate
     */
    @Override
    @Transactional
    public void updateShopUpdate(ShopUpdate shopUpdate) {
        shopUpdateDao.update(shopUpdate);
    }
}
