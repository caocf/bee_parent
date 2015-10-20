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
     * 返回商家所有组
     *
     * @param sid
     * @return
     */
    public List<ShopGroup> queryAdminShopGroupList(Long sid);

    /**
     * 返回一个商家组
     *
     * @param sgId
     * @return
     */
    public ShopGroup getAdminShopGroupById(long sgId);

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    public List<BusiShopGroup> getShopGroupByShopId(Long sid);

    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid);

    /**
     * 保存一个分组
     *
     * @param shopGroup
     * @throws DataRunException
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
