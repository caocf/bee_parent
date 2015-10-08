package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopGroupDao;
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
    public List<ShopGroup> getShopGroupByShopId(Long sid) {
        return shopGroupDao.getShopGroupByShopId(sid);
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
}
