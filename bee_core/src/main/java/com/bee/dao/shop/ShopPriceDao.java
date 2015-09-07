package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.modal.ShopPriceItem;
import com.bee.pojo.shop.ShopPrice;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
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

    /**
     * 查询价格列表 For App
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryAppShopPriceByShopId(long sid) {
        return findConverByParams(SQL.Shop.Price.queryAppShopPriceByShopId, new QueryDataConver<ShopPriceItem>() {
            @Override
            public ShopPriceItem converData(Object[] objs) {
                ShopPriceItem item = new ShopPriceItem();
                item.setPrice(NumberUtil.parseDouble(objs[0], 0));
                item.setRemark(StringUtil.parseString(objs[1], ""));
                return item;
            }
        }, sid);
    }

    /**
     *
     * @param id
     * @return
     */
    public ShopPrice getShopPriceById(long id) {
        return findFirstByParams(SQL.Shop.Price.getShopPriceById, id);
    }
}
