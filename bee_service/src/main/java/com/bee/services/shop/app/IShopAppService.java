package com.bee.services.shop.app;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.domain.modal.app.shop.Shop;
import com.bee.modal.ShopListItem;
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
    public PagingResult<ShopListItem> queryShopList(ShopListRequest req);


    /**
     * 根据ID查询商家信息
     *
     * @param sid
     * @return
     */
    public Shop getShop(long sid);
}
