package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.modal.ShopFocusFriendList;
import com.bee.pojo.shop.ShopFocus;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/30.
 */
@Repository
public class ShopFocusDao extends JpaDaoSupport<ShopFocus, Long> {

    public List<ShopFocus> getFocusList(long sid) {
        return findByParams(SQL.Shop.Focus.getFocusList, sid);
    }

    public List<ShopFocusFriendList> getShopFocusFriend(long sid, long uid) {
        return findConverByParams(SQL.Shop.Focus.getShopFocusFriend,
                new QueryDataConver<ShopFocusFriendList>() {
            @Override
            public ShopFocusFriendList converData(Object[] objects) {
                ShopFocusFriendList item = new ShopFocusFriendList();
                item.setName(StringUtil.parseString(objects[0], ""));
                item.setUid(NumberUtil.parseLong(objects[1], 0));
                item.setImage(StringUtil.parseString(objects[2], ""));
                return item;
            }
        }, uid, sid);
    }
}
