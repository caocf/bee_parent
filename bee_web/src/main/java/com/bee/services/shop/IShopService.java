package com.bee.services.shop;

import com.bee.client.params.shop.ShopListRequest;
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



}
