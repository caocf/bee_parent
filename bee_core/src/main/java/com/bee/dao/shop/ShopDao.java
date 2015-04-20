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
        entity.setParams(params.getType());
        StringBuffer sb = new StringBuffer(SQL.Shop.queryShopList);



        sb.append(SQL.Shop.queryShopListSort);
        entity.setEntity(sb.toString());
        entity.setPaging(params);
        return queryWithPaging(entity);
    }
}
