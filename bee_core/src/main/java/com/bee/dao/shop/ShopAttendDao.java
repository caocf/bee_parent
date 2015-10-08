package com.bee.dao.shop;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopAttend;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Repository
public class ShopAttendDao extends JpaDaoSupport<ShopAttend, Long> {

    /**
     * 查询商家出勤表
     *
     * @param sid
     * @return List<Long> 技师ID集合
     */
    public List<BusiShopAttend> getShopAttendByShopId(long sid, long attendTime) {
        return findConverByParams(SQL.Shop.Attend.GetShopAttendByShopId, new QueryDataConver<BusiShopAttend>() {
            @Override
            public BusiShopAttend converData(Object[] objects) {
                BusiShopAttend item = new BusiShopAttend();
                item.setTecheeId(NumberUtil.parseLong(objects[1], 0));
                return item;
            }
        }, sid, attendTime);
    }
}
