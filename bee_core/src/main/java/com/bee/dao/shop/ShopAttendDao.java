package com.bee.dao.shop;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopAttend;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Repository
public class ShopAttendDao extends JpaDaoSupport<ShopAttend, Long> {


    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    public List<ShopAttendItem> getAppShopAttendByShopId(long sid, long attendTime) {
        return findConverByParams(SQL.Shop.Attend.GetShopAttendByShopIdForApp,
                new QueryDataConver<ShopAttendItem>() {
            @Override
            public ShopAttendItem converData(Object[] objects) {
                ShopAttendItem item = new ShopAttendItem();
                item.setTecheeNumber(StringUtil.parseString(objects[0], ""));
                item.setGroupName(StringUtil.parseString(objects[1], ""));
                return item;
            }
        }, sid, attendTime);
    }

}
