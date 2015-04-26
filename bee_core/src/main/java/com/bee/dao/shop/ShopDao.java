package com.bee.dao.shop;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.SQL;
import com.bee.pojo.shop.Shop;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/4/16.
 */
@Repository
public class ShopDao extends JpaDaoSupport<Shop, Long> {

    /**
     * 查询商户列表
     *
     * @param params
     * @return
     */
    public PagingResult queryShopList(ShopListRequest params) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Shop.queryShopList);
        if(params.getType() != null && params.getType() >= 0) {
            sb.append(" and A.type = ?");
            entity.setParams(params.getType());
        }
        if(params.getName() != null && !"".equals(params.getName().trim())) {
            sb.append(" and A.name like ?");
            entity.setParams("%" + params.getName() + "%");
        }
        if(params.getPhone() != null && !"".equals(params.getPhone().trim())) {
            sb.append(" and A.phone like ?");
            entity.setParams("%" + params.getPhone() + "%");
        }
        if(params.getAreaId() != null) {
            sb.append(" and B.aid = ?");
            entity.setParams(params.getAreaId());
        }
        sb.append(SQL.Shop.queryShopListSort);
        entity.setEntity(sb.toString());
        entity.setPaging(params);
        return queryWithPaging(entity);
    }

    public Shop getShopById(long sid) {
        return findFirstByParams(SQL.Shop.queryShopById, sid);
    }
}
