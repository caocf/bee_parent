package com.bee.services.shop;

import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.modal.ShopPriceItem;
import com.bee.pojo.shop.ShopGroup;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
public interface IShopGroupService {

    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid);

}
