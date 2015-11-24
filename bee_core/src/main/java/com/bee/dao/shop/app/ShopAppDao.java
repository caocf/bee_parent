package com.bee.dao.shop.app;

import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.dao.shop.ShopDao;
import com.bee.domain.modal.app.shop.Shop;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/22.
 */
@Repository
public class ShopAppDao extends ShopDao {

    /**
     * <b>获取商家详细信息</b>
     * <p>APP商家详细界面</p>
     *
     * @param sid
     * @return
     */
    public Shop getShop(long sid) {
        return findFirstConverByParams(SQL.Shop.QueryAppShopItem + " and A.SID = " + sid, new QueryDataConver<Shop>() {
            @Override
            public Shop converData(Object[] obj) {
                Shop item = new Shop();
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
                item.setServiceTime(StringUtil.parseString(obj[14], "13:0-0:30"));
                return item;
            }
        }, sid);
    }


}
