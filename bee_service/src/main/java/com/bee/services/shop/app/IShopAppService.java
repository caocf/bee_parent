package com.bee.services.shop.app;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.bee.services.shop.IShopService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/22.
 */
public interface IShopAppService extends IShopService {


    /**
     * 查询APP商家列表
     *
     * @param req
     * @return
     */
    PagingResult<ShopListItem> queryShopList(ShopListRequest req);


    /**
     * 根据ID查询商家信息
     *
     * @param uid 用户ID
     * @param sid 商家ID
     * @return
     */
    ShopItem getShopItem(long uid, long sid);
}
