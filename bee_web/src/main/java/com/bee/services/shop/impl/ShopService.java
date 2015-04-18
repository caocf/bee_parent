package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.dao.shop.ShopDao;
import com.bee.services.shop.IShopService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopDao shopDao;

    public PagingResult queryShopList(ShopListRequest req) {
        return shopDao.queryShopList(req);
    }
}
