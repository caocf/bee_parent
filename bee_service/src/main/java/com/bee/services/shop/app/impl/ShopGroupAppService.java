package com.bee.services.shop.app.impl;

import com.bee.modal.ShopPriceItem;
import com.bee.services.shop.app.IShopGroupAppService;
import com.bee.services.shop.impl.ShopGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/11/19.
 */
@Service
public class ShopGroupAppService extends ShopGroupService implements IShopGroupAppService {

    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid) {
        return shopGroupDao.queryShopPriceByShopId(sid);
    }
}
