package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopGroupDao;
import com.bee.dao.shop.ShopTecheeDao;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopGroupService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopGroupService implements IShopGroupService {

    @Autowired
    protected ShopGroupDao shopGroupDao;
    @Autowired
    protected ShopDao shopDao;
    @Autowired
    protected ShopTecheeDao shopTecheeDao;


    /**
     * 删除一个分组
     *
     * @param shopGroupId
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShopGroup(long shopId, long shopGroupId) throws DataRunException {
        try {
            // 先删除所有技师
            deleteShopGroupTechee(shopGroupId);
            // 删除该组
            shopGroupDao.deleteById(shopGroupId);
            // 更新最低价格
            updateMinShopPrice(shopId);
        } catch (DataRunException e) {
            throw e;
        }
    }

    /**
     * 删除分组,同时删除该分组所有技师
     *
     * @param shopGroupId
     * @throws DataRunException
     */
    protected void deleteShopGroupTechee(long shopGroupId) throws DataRunException {
        shopTecheeDao.deleteShopGroupTechee(shopGroupId);
    }


    /**
     *
     *
     * @param shopId
     */
    protected void updateMinShopPrice(long shopId) {
        Shop shop = shopDao.getShopById(shopId);
        shop.setPrice(shopGroupDao.getShopGroupMinPrice(shopId));
        shopDao.update(shop);
    }
}
