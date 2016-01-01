package com.bee.services.shop.app;

import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.domain.params.shop.ShopFocusListParam;
import com.bee.services.shop.IShopFocusService;
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
}
