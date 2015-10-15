package com.bee.services.shop.impl;

import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.dao.shop.ShopGroupDao;
import com.bee.modal.ShopPriceItem;
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
        shopGroupDao.save(shopGroup);
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
        shopGroupDao.update(shopGroup);
    }

    /**
     * 删除一个分组
     *
     * @param shopGroupId
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShopGroup(long shopGroupId) throws DataRunException {
        shopGroupDao.deleteById(shopGroupId);
    }
}
