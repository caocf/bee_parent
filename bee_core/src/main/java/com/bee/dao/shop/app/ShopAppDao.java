package com.bee.dao.shop.app;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.shop.ShopDao;
import com.bee.domain.modal.app.shop.ShopItem;
import com.bee.domain.modal.app.shop.ShopListItem;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
@Repository
public class ShopAppDao extends ShopDao {

    /**
     * <b>获取商家详细信息</b>
     * <p>APP商家详细界面</p>
     *
     * @param sid 商家ID,指定商家
     * @return
     */
    public ShopItem getShopItemById(long sid) {
        return findFirstConverByParams(SQL.Shop.QueryAppShopItem + " and A.SID = ?", GetShopItemByIdConver, sid);
    }
    public static final QueryDataConver<ShopItem> GetShopItemByIdConver = new QueryDataConver<ShopItem>() {
        @Override
        public ShopItem converData(Object[] obj) {
            ShopItem item = new ShopItem();
            int index = 0;
            item.setShopId(NumberUtil.parseLong(obj[index++], 0));
            item.setName(StringUtil.parseString(obj[index++], ""));
            item.setAddr(StringUtil.parseString(obj[index++], ""));
            item.setPrice(NumberUtil.parseDouble(obj[index++], 0));
            item.setArea(StringUtil.parseString(obj[index++], ""));
            item.setFocusNum(NumberUtil.parseInteger(obj[index++], 0));
            item.setLon(NumberUtil.parseLong(obj[index++], 0));
            item.setLat(NumberUtil.parseLong(obj[index++], 0));
            item.setType(NumberUtil.parseInteger(obj[index++], Consts.Shop.Type.Club));
            item.setServiceTime(StringUtil.parseString(obj[index++], "13:0-0:30"));
            item.setIsFreeParking(NumberUtil.parseInteger(obj[index++], Consts.False));
            item.setIsFood(NumberUtil.parseInteger(obj[index++], Consts.False));
            item.setIsInvoice(NumberUtil.parseInteger(obj[index++], Consts.False));
            item.setIsPosCard(NumberUtil.parseInteger(obj[index++], Consts.False));
            // 为了兼容v1.0.4版本
            item.setPhone("");
            item.setLinkName("");
            item.setNowInfo("");
            item.setIsBack(Consts.False);
            // 删除好友关注数
            item.setFriendNum(0);
            // V1.2增加内容
            item.setHasVideo(NumberUtil.parseInteger(obj[index++], Consts.False));
            item.setVideoVer(NumberUtil.parseInteger(obj[index++], 0));
            return item;
        }
    };

    /**
     * <b>查询商家列表</b>
     * 主要用于APP首页商家列表
     *
     * @see com.bee.domain.modal.app.shop.ShopListItem
     * @param request
     * @return PagingResult<ShopListItem>
     */
    public PagingResult<ShopListItem> getShopList(ShopListRequest request) {
        SQLEntity entity = new SQLEntity();
        // 删除用户关注数
        // entity.setParam(request.getUid());
        StringBuffer sb = new StringBuffer(SQL.Shop.ShopListApp);
        if (request.getSearch() != null && !"".equals(request.getSearch())) {
            sb.append(" and A.name like ?");
            entity.setParam("%" + request.getSearch() + "%");
        }
        if (request.getType() != null && request.getType() >= 0) {
            sb.append(" and A.type = ?");
            entity.setParam(request.getType());
        }
        if (request.getAreaId() != null && request.getAreaId() > 1) {
            sb.append(" and B.aid = ?");
            entity.setParam(request.getAreaId());
        }
        sb.append(SQL.Shop.queryAppShopListSort);
        entity.setEntity(sb.toString());
        entity.setPaging(request);
        entity.setQueryDataConver(ShopListItemConver);
        return queryWithPagingConver(entity);
    }
    public static final QueryDataConver<ShopListItem> ShopListItemConver = new QueryDataConver<ShopListItem>() {
        @Override
        public ShopListItem converData(Object[] obj) {
            ShopListItem item = new ShopListItem();
            item.setShopId(NumberUtil.parseLong(obj[0], 0));
            item.setName(StringUtil.parseString(obj[1], ""));
            item.setAddr(StringUtil.parseString(obj[2], ""));
            item.setPrice(NumberUtil.parseDouble(obj[3], 0));
            item.setArea(StringUtil.parseString(obj[4], ""));
            item.setFocusNum(NumberUtil.parseInteger(obj[5], 0));
            item.setType(NumberUtil.parseInteger(obj[6], Consts.Shop.Type.Club));
            item.setIsBeeShop(NumberUtil.parseInteger(obj[7], Consts.False));
            item.setHasVideo(NumberUtil.parseInteger(obj[8], Consts.False));
            // 取消好友关注数
            item.setFriendNum(0);
            item.setIsBack(Consts.False);
            return item;
        }
    };

    /**
     * 查询商家推广信息
     *
     * @return
     */
    public List<ShopListItem> queryRecommendShop() {
        return findConverByParams(SQL.Shop.queryRecommendShop, ShopListItemConver);
    }

}
