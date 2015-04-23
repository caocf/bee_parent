package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopImage;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
@Repository
public class ShopImageDao extends JpaDaoSupport<ShopImage, Long> {

    /**
     *
     *
     * @param sid
     * @return
     */
    public List<ShopImage> queryShopImageByShopId(long sid) {
        return findByParams(SQL.Shop.Image.queryShopImageByShopId, sid);
    }

    /**
     *
     * @param id
     * @return
     */
    public ShopImage getShopImageById(long id) {
        return findFirstByParams(SQL.Shop.Image.getShopImageById, id);
    }

}
