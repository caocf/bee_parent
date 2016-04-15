package com.bee.services.shop.admin;

import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.IShopGroupService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopGroupAdminService extends IShopGroupService {

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
    void saveShopGroup(ShopGroup shopGroup) throws DataRunException;

    /**
     * 更新一个分组
     *
     * @param shopGroup
     * @throws DataRunException
     */
    void updateShopGroup(ShopGroup shopGroup) throws DataRunException;

}
