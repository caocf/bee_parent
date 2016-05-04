package com.bee.services.stat.app;

import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;
import com.bee.services.stat.IShopStatService;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 16/5/4.
 */
public interface IShopStatAppService extends IShopStatService {

    /**
     * 添加统计
     *
     * @param shop 所属商家
     * @param user 所属用户
     * @throws DataRunException
     */
    void addShopStat(Shop shop, User user) throws DataRunException;
}
