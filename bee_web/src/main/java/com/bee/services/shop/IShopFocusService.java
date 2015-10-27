package com.bee.services.shop;

import com.bee.app.model.shop.ShopFocusItem;
import com.bee.app.params.shop.ShopFocusListRequest;
import com.bee.modal.ShopFocusFriendList;
import com.bee.pojo.shop.ShopFocus;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

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
     * 判断是否关注
     *
     * @param sid
     * @param uid
     * @return
     */
    public ShopFocus getFoucsShop(long sid, long uid);

    /**
     * 添加用户关注
     *
     * @throws DataRunException
     */
    public void addShopFocus(long uid, long shopId) throws DataRunException;

    /**
     * 返回用户所有关注商户
     *
     * @return
     */
    public PagingResult<ShopFocusItem> getShopFocusList(ShopFocusListRequest request);
}
