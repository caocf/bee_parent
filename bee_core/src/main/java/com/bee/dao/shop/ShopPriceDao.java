package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopPrice;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@Repository
public class ShopPriceDao extends JpaDaoSupport<ShopPrice, Long> {

    /**
     *
     *
     * @param sid
     * @return
     */
    public List<ShopPrice> queryShopPriceByShopId(long sid) {
        return findByParams(SQL.Shop.Price.queryShopPriceByShopId, sid);
    }
}
