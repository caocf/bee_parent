package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopUser;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/9/13.
 */
@Repository
public class ShopUserDao extends JpaDaoSupport<ShopUser, Long> {


    /**
     * 查询商家管理员
     * 用于创建订单时，传入该订单服务经理，目前主要采用单经理模式
     *
     * @param shopId 所属商家ID
     * @return
     */
    public ShopUser getShopUserByShopId(long shopId) {
        return findFirstByParams(SQL.Shop.User.getShopUserByShopId, shopId);
    }

}
