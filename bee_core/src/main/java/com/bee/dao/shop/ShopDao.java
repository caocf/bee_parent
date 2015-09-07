package com.bee.dao.shop;

import com.bee.client.params.shop.AdminShopListRequest;
import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.RecommendItem;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.modal.ShopMap;
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
    public PagingResult<Shop> queryShopList(AdminShopListRequest params) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Shop.queryShopList);
        if (params.getType() != null && params.getType() >= 0) {
            sb.append(" and A.type = ?");
            entity.setParams(params.getType());
        }
        if (params.getName() != null && !"".equals(params.getName().trim())) {
            sb.append(" and A.name like ?");
            entity.setParams("%" + params.getName() + "%");
        }
        if (params.getPhone() != null && !"".equals(params.getPhone().trim())) {
            sb.append(" and A.phone like ?");
            entity.setParams("%" + params.getPhone() + "%");
        }
        if (params.getAreaId() != null) {
            sb.append(" and B.aid = ?");
            entity.setParams(params.getAreaId());
        }
        sb.append(SQL.Shop.queryShopListSort);
        entity.setEntity(sb.toString());
        entity.setPaging(params);
        return queryWithPaging(entity);
    }


    public List<ShopListItem> queryRecommendShop(long uid) {
        return findConverByParams(SQL.Shop.queryRecommendShop, new QueryDataConver<ShopListItem>() {
            @Override
            public ShopListItem converData(Object[] obj) {
                ShopListItem item = new ShopListItem();
                item.setShopId(NumberUtil.parseLong(obj[0], 0));
                item.setName(StringUtil.parseString(obj[1], ""));
                item.setAddr(StringUtil.parseString(obj[2], ""));
                item.setPrice(NumberUtil.parseDouble(obj[3], 0));
                item.setArea(StringUtil.parseString(obj[4], ""));
                item.setFocusNum(NumberUtil.parseInteger(obj[5], 0));
                item.setFriendNum(NumberUtil.parseInteger(obj[6], 0));
                item.setLon(NumberUtil.parseLong(obj[7], 0));
                item.setLat(NumberUtil.parseLong(obj[8], 0));
                item.setPhone(StringUtil.parseString(obj[9], ""));
                item.setType(NumberUtil.parseInteger(obj[10], Consts.Shop.Type.Club));
                item.setLinkName(StringUtil.parseString(obj[11], ""));
                item.setNowInfo(StringUtil.parseString(obj[12], ""));
                item.setIsBack(NumberUtil.parseInteger(obj[13], Consts.False));
                return item;
            }
        }, uid);
    }

    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest request) {
        SQLEntity entity = new SQLEntity();
        entity.setParam(request.getUid());
        StringBuffer sb = new StringBuffer(SQL.Shop.queryAppShopList);
        if (request.getSearch() != null && !"".equals(request.getSearch())) {
            sb.append(" and A.name like ?");
            entity.setParams("%" + request.getSearch() + "%");
        }
        if (request.getType() != null && request.getType() >= 0) {
            sb.append(" and A.type = ?");
            entity.setParams(request.getType());
        }
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
                item.setFocusNum(NumberUtil.parseInteger(obj[5], 0));
                item.setFriendNum(NumberUtil.parseInteger(obj[6], 0));
                item.setLon(NumberUtil.parseLong(obj[7], 0));
                item.setLat(NumberUtil.parseLong(obj[8], 0));
                item.setPhone(StringUtil.parseString(obj[9], ""));
                item.setType(NumberUtil.parseInteger(obj[10], Consts.Shop.Type.Club));
                item.setLinkName(StringUtil.parseString(obj[11], ""));
                item.setNowInfo(StringUtil.parseString(obj[12], ""));
                item.setIsBack(NumberUtil.parseInteger(obj[13], Consts.False));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }

    public ShopListItem getShopItemById(long sid) {
        return findFirstConverByParams(SQL.Shop.queryAppShopList + " and A.SID = " + sid, new QueryDataConver<ShopListItem>() {
            @Override
            public ShopListItem converData(Object[] obj) {
                ShopListItem item = new ShopListItem();
                item.setShopId(NumberUtil.parseLong(obj[0], 0));
                item.setName(StringUtil.parseString(obj[1], ""));
                item.setAddr(StringUtil.parseString(obj[2], ""));
                item.setPrice(NumberUtil.parseDouble(obj[3], 0));
                item.setArea(StringUtil.parseString(obj[4], ""));
                item.setFocusNum(NumberUtil.parseInteger(obj[5], 0));
                item.setFriendNum(NumberUtil.parseInteger(obj[6], 0));
                item.setLon(NumberUtil.parseLong(obj[7], 0));
                item.setLat(NumberUtil.parseLong(obj[8], 0));
                item.setPhone(StringUtil.parseString(obj[9], ""));
                item.setType(NumberUtil.parseInteger(obj[10], Consts.Shop.Type.Club));
                item.setLinkName(StringUtil.parseString(obj[11], ""));
                item.setNowInfo(StringUtil.parseString(obj[12], ""));
                item.setIsBack(NumberUtil.parseInteger(obj[13], Consts.False));
                return item;
            }
        }, sid);
    }

    public Shop getShopById(long sid) {
        return findFirstByParams(SQL.Shop.queryShopById, sid);
    }


    public List<ShopMap> queryShopMapAll() {
        return findConverByParams(SQL.Shop.queryShopMap, new QueryDataConver<ShopMap>() {
            @Override
            public ShopMap converData(Object[] obj) {
                ShopMap item = new ShopMap();
                item.setShopId(NumberUtil.parseLong(obj[0], 0));
                item.setName(StringUtil.parseString(obj[1], ""));
                item.setAddr(StringUtil.parseString(obj[2], ""));
                long lon = NumberUtil.parseLong(obj[3], 0);
                item.setLon(lon > 0 ? lon / 1E6 : 0);
                long lat = NumberUtil.parseLong(obj[4], 0);
                item.setLat(lat > 0 ? lat / 1E6 : 0);
                return item;
            }
        });
    }
}
