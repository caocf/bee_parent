package com.bee.services.shop.impl;

import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopGroupDao;
import com.bee.modal.ShopPriceItem;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopGroup;
import com.bee.services.shop.IShopGroupService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Service
public class ShopGroupService implements IShopGroupService {

    @Autowired
    private ShopGroupDao shopGroupDao;
    @Autowired
    private ShopDao shopDao;

    /**
     *
     * @param sid
     * @return
     */
    @Override
    public List<ShopGroup> queryAdminShopGroupList(Long sid) {
        return shopGroupDao.queryAdminShopGroupList(sid);
    }

    /**
     * 返回一个商家组
     *
     * @param sgId
     * @return
     */
    @Override
    public ShopGroup getAdminShopGroupById(long sgId) {
        return shopGroupDao.getAdminShopGroupById(sgId);
    }

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    public List<BusiShopGroup> getShopGroupByShopId(Long sid) {
        return shopGroupDao.getShopGroupByShopId(sid);
    }

    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid) {
        return shopGroupDao.queryShopPriceByShopId(sid);
    }

    /**
     * 保存一个分组
     *
     * @param shopGroup
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void saveShopGroup(ShopGroup shopGroup) throws DataRunException {
        try {
            // 保存一个商家分组
            shopGroupDao.save(shopGroup);
            // 修改商家最低价
            updateMinShopPrice(shopGroup.getShop().getSid());
        } catch (DataRunException e) {
            throw e;
        }
    }

    /**
     * 更新一个分组
     *
     * @param shopGroup
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void updateShopGroup(ShopGroup shopGroup) throws DataRunException {
        try {
            shopGroupDao.update(shopGroup);
            // 修改商家最低价
            updateMinShopPrice(shopGroup.getShop().getSid());
        } catch (DataRunException e) {
            throw e;
        }
    }

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
            shopGroupDao.deleteById(shopGroupId);
            updateMinShopPrice(shopId);
        } catch (DataRunException e) {
            throw e;
        }
    }

    /**
     *
     *
     * @param shopId
     */
    private void updateMinShopPrice(long shopId) {
        Shop shop = shopDao.getShopById(shopId);
        shop.setPrice(shopGroupDao.getShopGroupMinPrice(shopId));
        shopDao.update(shop);
    }

}
