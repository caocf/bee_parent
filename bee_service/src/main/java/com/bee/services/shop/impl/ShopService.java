package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopDao;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopService implements IShopService {

    @Autowired
    protected ShopDao shopDao;

    /**
     * 单独返回一个商家实体
     *
     * @param sid
     * @return
     */
    @Override
    public Shop getShopById(long sid) {
        return shopDao.getShopById(sid);
    }

    /**
     * 更新商家信息
     *
     * @param shop
     */
    @Override
    @Transactional
    public void update(Shop shop) throws DataRunException {
        shopDao.update(shop);
    }
}
