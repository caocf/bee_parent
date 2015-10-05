package com.bee.services.shop;

import com.bee.busi.model.user.BusiShopUser;

/**
 * Created by suntongwei on 15/9/13.
 */
public interface IShopUserService {


    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    public BusiShopUser getShopUserByLogin(long uid);
}
