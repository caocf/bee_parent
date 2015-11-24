package com.bee.dao.shop;

import com.bee.app.model.shop.ShopFocusItem;
import com.bee.app.params.shop.ShopFocusListRequest;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.modal.ShopFocusFriendList;
import com.bee.pojo.shop.ShopFocus;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.spring.Paging;
import com.qsd.framework.spring.PagingResult;
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
        return findConverByParams(SQL.Shop.Focus.GetShopFocusFriend,
                new QueryDataConver<ShopFocusFriendList>() {
            @Override
            public ShopFocusFriendList converData(Object[] objects) {
                ShopFocusFriendList item = new ShopFocusFriendList();
                item.setName(StringUtil.parseString(objects[0], ""));
                item.setUid(NumberUtil.parseLong(objects[1], 0));
                return item;
            }
        }, uid, sid);
    }


    public ShopFocus getFoucsShop(long sid, long uid) {
        return findFirstByParams(SQL.Shop.Focus.GetFocusShop, sid, uid);
    }

    /**
     *
     *
     * @return
     */
    public PagingResult<ShopFocusItem> getShopFocusList(ShopFocusListRequest request) {
        SQLEntity entity = new SQLEntity(SQL.Shop.Focus.GetShopFocusList);
        entity.setParams(request.getUid());
        entity.setPaging(request);
        entity.setQueryDataConver(new QueryDataConver<ShopFocusItem>() {
            @Override
            public ShopFocusItem converData(Object[] row) {
                ShopFocusItem item = new ShopFocusItem();
                item.setShopId(NumberUtil.parseLong(row[0], 0));
                item.setName(StringUtil.parseString(row[1], ""));
                return item;
            }
        });
        return queryWithPagingConver(entity);
    }



}
