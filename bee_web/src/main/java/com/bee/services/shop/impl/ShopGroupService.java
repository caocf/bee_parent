package com.bee.services.shop.impl;

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

    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid) {
        return shopGroupDao.queryShopPriceByShopId(sid);
    }



}
