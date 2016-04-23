package com.bee.services.shop.busi.impl;

import com.bee.pojo.shop.ShopConfig;
import com.bee.services.shop.busi.IShopConfigBusiService;
import com.bee.services.shop.impl.ShopConfigService;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 16/4/23.
 */
@Service
public class ShopConfigBusiService extends ShopConfigService implements IShopConfigBusiService {


    /**
     *
     * @param shopId
     * @return
     */
    @Override
    public ShopConfig getShopConfigById(long shopId) {
        return shopConfigDao.getShopConfigByShopId(shopId);
    }
}
