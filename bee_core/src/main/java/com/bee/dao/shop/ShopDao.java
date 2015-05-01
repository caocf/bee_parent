package com.bee.dao.shop;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.SQL;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.pojo.shop.Shop;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public PagingResult queryShopList(AdminShopListRequest params) {
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


    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest request) {
        SQLEntity entity = new SQLEntity();
        entity.setParam(request.getUid());
        StringBuffer sb = new StringBuffer(SQL.Shop.queryAppShopList);

        sb.append(SQL.Shop.queryAppShopListSort);
        entity.setEntity(sb.toString());
        entity.setPaging(request);
        entity.setQueryDataConver(new QueryDataConver<ShopListItem>() {
            @Override
            public ShopListItem converData(Object[] obj) {
                ShopListItem item = new ShopListItem();
                item.setShopId(NumberUtil.parseLong(obj[0], 0));
                item.setName(StringUtil.parseString(obj[1], ""));
                item.setAddr(StringUtil.parseString(obj[2], ""));
                item.setPrice(NumberUtil.parseDouble(obj[3], 0));
                item.setArea(StringUtil.parseString(obj[4], ""));
                item.setImage(StringUtil.parseString(obj[5], ""));
                item.setFocusNum(NumberUtil.parseInteger(obj[6], 0));
                item.setFriendNum(NumberUtil.parseInteger(obj[7], 0));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }

    public ShopItem getShopItemById(long sid) {
        return findFirstConverByParams(SQL.Shop.getShopItemById, new QueryDataConver<ShopItem>() {
            @Override
            public ShopItem converData(Object[] obj) {
                ShopItem item = new ShopItem();
                item.setShopId(NumberUtil.parseLong(obj[0], 0));
                item.setName(StringUtil.parseString(obj[1], ""));
                item.setPrice(NumberUtil.parseDouble(obj[2], 0d));
                item.setLinkMan(StringUtil.parseString(obj[3], ""));
                item.setPhone(StringUtil.parseString(obj[4], ""));
                item.setAddr(StringUtil.parseString(obj[5], ""));
                item.setRemark(StringUtil.parseString(obj[6], ""));
                long lon = NumberUtil.parseLong(obj[7], 0);
                item.setLon(lon > 0 ? lon / 1E6 : 0d);
                long lat = NumberUtil.parseLong(obj[8], 0);
                item.setLat(lat > 0 ? lat / 1E6 : 0d);
                item.setArea(StringUtil.parseString(obj[9], ""));
                item.setImage(StringUtil.parseString(obj[10], ""));
                return item;
            }
        }, sid);
    }

    public Shop getShopById(long sid) {
        return findFirstByParams(SQL.Shop.queryShopById, sid);
    }
}
