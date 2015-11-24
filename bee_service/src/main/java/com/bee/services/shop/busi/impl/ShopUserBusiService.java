package com.bee.services.shop.busi.impl;

import com.bee.busi.model.user.BusiShopUser;
import com.bee.services.shop.busi.IShopUserBusiService;
import com.bee.services.shop.impl.ShopUserService;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopUserBusiService extends ShopUserService implements IShopUserBusiService {


    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    @Override
    public BusiShopUser getShopUserByLogin(long uid) {
        return shopUserDao.getShopUserByLogin(uid);
    }
}
