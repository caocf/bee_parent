package com.bee.services.shop.busi;

import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.IShopGroupService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopGroupBusiService extends IShopGroupService {


    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    List<BusiShopGroup> getShopGroupByShopId(Long sid);

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
