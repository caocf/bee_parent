package com.bee.services.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.pojo.shop.Shop;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/4/16.
 */
public interface IShopService {

    /**
     * 查询商家列表
     *
     * @param req
     * @return
     */
    public PagingResult queryShopList(ShopListRequest req);

    /**
     * 增加商家
     *
     * @throws DataRunException
     */
    public void addShop(Shop shop) throws DataRunException;
}
