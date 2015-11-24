package com.bee.services.shop.busi;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.params.shop.ShopAttendSaveRequest;
import com.bee.services.shop.IShopAttendService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopAttendBusiService extends IShopAttendService {

    /**
     * 查询商家出勤表，大于查询时间
     *
     * @param sid
     * @param attendTime
     * @return
     */
    List<BusiShopAttend> getShopAttendByShopIdAfter(long sid, long attendTime);

    /**
     * 保存商家出勤表
     *
     * @param req
     */
    void saveShopAttend(ShopAttendSaveRequest req) throws DataRunException;

    /**
     * 根据时间删除出勤表
     *
     * @param attendTime
     * @throws DataRunException
     */
    void deleteShopAttend(long sid, long attendTime) throws DataRunException;


    /**
     * 【B端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    List<BusiShopAttend> getShopAttendByShopId(long sid, long attendTime);
}
