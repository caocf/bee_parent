package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.dao.shop.app.ShopAppDao;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.bee.modal.ShopMap;
import com.bee.services.shop.IShopService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopAppDao shopDao;

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest req) {
        return shopDao.queryAppShopList(req);
    }

    /**
     *
     * @param uid
     * @return
     */
    @Override
    public List<ShopListItem> queryRecommendShop(long uid) {
        return shopDao.queryRecommendShop(uid);
    }

    /**
     *
     * @param sid
     * @return
     */
    @Override
    public ShopItem getShopItemById(long sid) {
        return shopDao.getShopItemById(0, sid);
    }


    /**
     *
     * @return
     */
    @Override
    public List<ShopMap> queryShopMapAll() {
        return shopDao.queryShopMapAll();
    }
}
