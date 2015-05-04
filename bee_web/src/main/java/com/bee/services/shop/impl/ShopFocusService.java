package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopFocusDao;
import com.bee.modal.ShopFocusFriendList;
import com.bee.pojo.shop.ShopFocus;
import com.bee.services.shop.IShopFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
