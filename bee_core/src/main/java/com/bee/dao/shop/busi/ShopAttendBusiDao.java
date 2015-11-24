package com.bee.dao.shop.busi;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.commons.SQL;
import com.bee.dao.shop.ShopAttendDao;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
@Repository
public class ShopAttendBusiDao extends ShopAttendDao {

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
                item.setSaId(NumberUtil.parseLong(objects[0], 0));
                item.setShopTechee(NumberUtil.parseLong(objects[1], 0));
                item.setAttendTime(NumberUtil.parseLong(objects[2], 0));
                item.setShop(NumberUtil.parseLong(objects[3], 0));
                return item;
            }
        }, sid, attendTime);
    }

    /**
     * 查询商家所有出勤表，大于查询时间
     *
     * @param sid
     * @param attendTime
     * @return
     */
    public List<BusiShopAttend> getShopAttendByShopIdAfter(long sid, long attendTime) {
        return findConverByParams(SQL.Shop.Attend.GetShopAttendByShopIdAfter,
                new QueryDataConver<BusiShopAttend>() {
                    @Override
                    public BusiShopAttend converData(Object[] objects) {
                        BusiShopAttend item = new BusiShopAttend();
                        item.setSaId(NumberUtil.parseLong(objects[0], 0));
                        item.setShopTechee(NumberUtil.parseLong(objects[1], 0));
                        item.setAttendTime(NumberUtil.parseLong(objects[2], 0));
                        item.setShop(NumberUtil.parseLong(objects[3], 0));
                        return item;
                    }
                }, sid, attendTime);
    }

    /**
     * 根据时间删除出勤表
     *
     * @param attendTime
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    public void deleteShopAttend(long sid, long attendTime) throws DataRunException {
        execute(SQL.Shop.Attend.DeleteShopAttend, sid, attendTime);
    }
}
