package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopPriceDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopPrice;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import com.sun.tools.internal.jxc.apt.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopDao shopDao;
    @Autowired
    private ShopPriceDao shopPriceDao;

    public PagingResult queryShopList(ShopListRequest req) {
        return shopDao.queryShopList(req);
    }

    @Override
    @Transactional
    public void addShop(Shop shop) throws DataRunException {
        try {
            shop.setCreateTime(System.currentTimeMillis());
            shop.setIdentity("S" + shop.getCreateTime());
            shop.setSort(0);
            shop.setRecommend(Consts.False);
            shop.setPrice(0d);
            shopDao.save(shop);
        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    public Shop getShopById(long sid) {
        return shopDao.findById(sid);
    }
}
