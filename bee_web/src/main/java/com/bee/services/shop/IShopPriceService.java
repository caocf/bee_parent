package com.bee.services.shop;

import com.bee.pojo.shop.ShopPrice;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/4/16.
 */
public interface IShopPriceService {

    /**
     * 增加商户价格
     *
     * @param shopPrice
     * @throws DataRunException
     */
    public void addShopPrice(ShopPrice shopPrice) throws DataRunException;
}
