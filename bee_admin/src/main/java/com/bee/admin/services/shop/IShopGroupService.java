package com.bee.admin.services.shop;

import com.bee.pojo.shop.ShopGroup;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/8.
 */
public interface IShopGroupService {


    /**
     * 返回商家所有组
     *
     * @param sid
     * @return
     */
    List<ShopGroup> queryAdminShopGroupList(Long sid);

    /**
     * 返回一个商家组
     *
     * @param sgId
     * @return
     */
    ShopGroup getAdminShopGroupById(long sgId);


    /**
     * 保存一个分组
     *
     * @param shopGroup
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    public void saveShopGroup(ShopGroup shopGroup) throws DataRunException;

    /**
     * 更新一个分组
     *
     * @param shopGroup
     * @throws DataRunException
     */
    public void updateShopGroup(ShopGroup shopGroup) throws DataRunException;

    /**
     * 删除一个分组
     *
     * @param shopGroupId
     * @throws DataRunException
     */
    public void deleteShopGroup(long shopId, long shopGroupId) throws DataRunException;
}
