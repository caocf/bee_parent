package com.bee.services.stat.app.impl;

import com.bee.pojo.shop.Shop;
import com.bee.pojo.stat.ShopStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.app.IShopStatAppService;
import com.bee.services.stat.impl.ShopStatService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by suntongwei on 16/5/4.
 */
@Service
public class ShopStatAppService extends ShopStatService implements IShopStatAppService {


    /**
     *
     * @param shop 所属商家
     * @param user 所属用户
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void addShopStat(Shop shop, User user) throws DataRunException {
        ShopStat shopStat = new ShopStat();
        shopStat.setShop(shop);
        shopStat.setUser(user);
        shopStat.setCreateTime(System.currentTimeMillis());
        shopStat.setDevice("");
        shopStatDao.save(shopStat);
    }
}
