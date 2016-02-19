package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopUpdate;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 16/2/17.
 */
@Repository
public class ShopUpdateDao extends JpaDaoSupport<ShopUpdate, Long> {

    /**
     *
     * @param shopId
     * @return
     */
    public ShopUpdate getShopUpdateByShopId(Long shopId) {
        return findFirstByParams(SQL.Shop.Update.GetShopUpdateByShopId, shopId);
    }

    /**
     * 创建一个ShopUpdate
     *
     * @param shopId
     */
    public ShopUpdate create(Long shopId) {
        ShopUpdate shopUpdate = new ShopUpdate();
        shopUpdate.setShop(new Shop(shopId));
        shopUpdate.setUpdateTechee(0l);
        save(shopUpdate);
        return shopUpdate;
    }

}
