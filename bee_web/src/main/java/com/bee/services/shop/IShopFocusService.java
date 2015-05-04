package com.bee.services.shop;

import com.bee.modal.ShopFocusFriendList;

import java.util.List;

/**
 * Created by suntongwei on 15/4/26.
 */
public interface IShopFocusService {

    /**
     * 根据商家ID和用户ID查询用户好友关注
     *
     * @param sid
     * @param uid
     * @return
     */
    public List<ShopFocusFriendList> getShopFocusFriend(long sid, long uid);

}
