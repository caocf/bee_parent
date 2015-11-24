package com.bee.services.shop.busi;

import com.bee.busi.model.user.BusiShopUser;
import com.bee.services.shop.IShopUserService;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopUserBusiService extends IShopUserService {

    /**
     *
     * @param uid
     * @return
     */
    BusiShopUser getShopUserByLogin(long uid);
}
