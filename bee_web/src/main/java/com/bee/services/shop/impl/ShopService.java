package com.bee.services.shop.impl;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopFocusDao;
import com.bee.dao.shop.ShopImageDao;
import com.bee.dao.user.UserFriendDao;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopFocus;
import com.bee.pojo.user.User;
import com.bee.pojo.user.UserFriend;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopDao shopDao;

    public PagingResult<Shop> queryShopList(AdminShopListRequest req) {
        return shopDao.queryShopList(req);
    }

    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest req) {
        return shopDao.queryAppShopList(req);
    }

    public List<RecommendItem> queryRecommendShop() {
        return shopDao.queryRecommendShop();
    }

    @Override
    @Transactional
    public void addShop(Shop shop) throws DataRunException {
        try {
            shop.setCreateTime(System.currentTimeMillis());
            shop.setIdentity("S" + shop.getCreateTime());
            shop.setRecommend(Consts.False);
            shop.setPrice(0d);
            shop.setStatus(Consts.Shop.Status.Run);
            if(null == shop.getSort()) {
                shop.setSort(100);
            }
            shopDao.save(shop);
        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    public Shop getShopById(long sid) {
        return shopDao.getShopById(sid);
    }

    @Override
    public ShopItem getShopItemById(long sid) {
        return shopDao.getShopItemById(sid);
    }

    @Override
    @Transactional
    public void deleteShop(long sid) throws DataRunException {
        Shop shop = shopDao.findById(sid);
        shop.setStatus(Consts.Shop.Status.Close);
        shopDao.update(shop);
    }

    @Override
    @Transactional
    public void updateShop(Shop shop) throws DataRunException {
        shopDao.update(shop);
    }
}
