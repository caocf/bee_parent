package com.bee.services.shop.app;

import com.bee.modal.ShopPriceItem;
import com.bee.services.shop.IShopGroupService;

import java.util.List;

/**
 * Created by suntongwei on 15/11/19.
 */
public interface IShopGroupAppService extends IShopGroupService {

    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid);
}
