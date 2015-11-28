package com.bee.dao.shop;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopAttend;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.Paging;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Repository
public class ShopAttendDao extends JpaDaoSupport<ShopAttend, Long> {

    /**
     * 返回商家出勤最后更新时间
     *
     * @param shopId
     * @return
     */
    public Long getShopAttendLastUpdateTime(long shopId) {
        HQLEntity entity = new HQLEntity(SQL.Shop.Attend.GetShopAttendLastUpdateTime);
        entity.setParams(shopId);
        ShopAttend shopAttend = querySingleResult(entity);
        return shopAttend != null && shopAttend.getAttendTime() != null ? shopAttend.getAttendTime() : null;
    }

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
