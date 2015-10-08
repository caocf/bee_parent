package com.bee.dao.shop;


import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopTechee;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Repository
public class ShopTecheeDao extends JpaDaoSupport<ShopTechee, Long> {

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    public List<ShopTechee> getShopTecheeByGroupId(long gid) {
        return findByParams(SQL.Shop.Techee.GetShopTecheeByGroupId, gid);
    }
}
