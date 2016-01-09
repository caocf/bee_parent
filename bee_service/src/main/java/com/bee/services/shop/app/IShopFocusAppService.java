package com.bee.services.shop.app;

import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.domain.params.shop.ShopFocusListParam;
import com.bee.pojo.shop.ShopFocus;
import com.bee.services.shop.IShopFocusService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/17.
 */
public interface IShopFocusAppService extends IShopFocusService {

    /**
     * 获取用户关注的所有商家列表
     *
     * @return
     */
    PagingResult<ShopFavorite> getShopFocusListByParam(ShopFocusListParam param);

    /**
     * 获取用户和商家的关注关系
     *
     * @param shopId
     * @param userId
     * @return
     */
    ShopFocus getShopFocusByUser(Long shopId, Long userId);

    /**
     * 给用户添加关注
     *
     * @param shopId
     * @param userId
     * @throws DataRunException
     */
    void addShopFocus(Long shopId, Long userId) throws DataRunException;
}
