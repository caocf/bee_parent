package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopGroup;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Repository
public class ShopGroupDao extends JpaDaoSupport<ShopGroup, Long> {

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    public List<ShopGroup> getShopGroupByShopId(Long sid) {
        return findByParams(SQL.Shop.Group.GetShopGroupByShopId, sid);
    }
}
