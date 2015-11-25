package com.bee.services.shop.app.impl;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.dao.shop.app.ShopAppDao;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.bee.services.shop.app.IShopAppService;
import com.bee.services.shop.impl.ShopService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/22.
 */
@Service
public class ShopAppService extends ShopService implements IShopAppService {

    @Autowired
    private ShopAppDao shopAppDao;

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<ShopListItem> queryShopList(ShopListRequest req) {
        return shopAppDao.getShopList(req);
    }

    /**
     *
     * @param shopId
     * @return
     */
    @Override
    public ShopItem getShop(long shopId) {
        return shopAppDao.getShopItemById(shopId);
    }
}
