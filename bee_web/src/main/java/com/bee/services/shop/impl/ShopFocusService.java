package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopFocusDao;
import com.bee.modal.ShopFocusFriendList;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopFocus;
import com.bee.pojo.user.User;
import com.bee.services.shop.IShopFocusService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/4/26.
 */
@Service
public class ShopFocusService implements IShopFocusService {

    @Autowired
    private ShopFocusDao shopFocusDao;

    @Override
    public List<ShopFocusFriendList> getShopFocusFriend(long sid, long uid) {
        return shopFocusDao.getShopFocusFriend(sid, uid);
    }


    @Override
    @Transactional
    public void addShopFocus(long uid, long shopId) throws DataRunException {
        ShopFocus shopFocus = new ShopFocus();
        shopFocus.setUser(new User(uid));
        shopFocus.setShop(new Shop(shopId));
        shopFocusDao.save(shopFocus);
    }

    @Override
    public ShopFocus getsFoucsShop(long sid, long uid) {
        return shopFocusDao.getFoucsShop(sid, uid);
    }
}
