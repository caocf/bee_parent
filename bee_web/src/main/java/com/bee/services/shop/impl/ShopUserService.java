package com.bee.services.shop.impl;

import com.bee.busi.model.user.BusiShopUser;
import com.bee.dao.shop.ShopUserDao;
import com.bee.services.shop.IShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/9/13.
 */
@Service
public class ShopUserService implements IShopUserService {

    @Autowired
    private ShopUserDao shopUserDao;


    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    public BusiShopUser getShopUserByLogin(long uid) {
        return shopUserDao.getShopUserByLogin(uid);
    }

}
