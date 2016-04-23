package com.bee.dao.shop;

import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopConfig;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 16/4/23.
 */
@Repository
public class ShopConfigDao extends JpaDaoSupport<ShopConfig, Long> {

    public static final String GetShopConfigByShopId = "From ShopConfig A where A.shop.sid = ?";

    /**
     * 获取商家配置信息
     *
     * @param shopId
     * @return
     */
    public ShopConfig getShopConfigByShopId(long shopId) {
        return findFirstByParams(GetShopConfigByShopId, shopId);
    }

    /**
     * 返回一个默认值的ShopConfig
     *
     * @param shopId
     * @return
     */
    public ShopConfig getDefaultShopConfig(long shopId) {
        ShopConfig shopConfig = new ShopConfig();
        shopConfig.setShop(new Shop(shopId));
        shopConfig.setHasVideo(Consts.False);
        save(shopConfig);
        return shopConfig;
    }

}
