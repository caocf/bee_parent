package com.bee.services.shop;

import com.bee.pojo.shop.ShopGroup;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
public interface IShopGroupService {

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    public List<ShopGroup> getShopGroupByShopId(Long sid);

    /**
     * 保存一个分组
     *
     * @param shopGroup
     * @throws DataRunException
     */
    public void saveShopGroup(ShopGroup shopGroup) throws DataRunException;
}
