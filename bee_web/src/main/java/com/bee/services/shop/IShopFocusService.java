package com.bee.services.shop;

import com.bee.modal.ShopFocusFriendList;
import com.qsd.framework.hibernate.exception.DataRunException;

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

    /**
     * 添加用户关注
     *
     * @throws DataRunException
     */
    public void addShopFocus(long uid, long shopId) throws DataRunException;
}
