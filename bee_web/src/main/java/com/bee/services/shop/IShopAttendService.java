package com.bee.services.shop;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.params.shop.ShopAttendSaveRequest;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
public interface IShopAttendService {

    /**
     * 保存商家出勤表
     *
     * @param req
     */
    public void saveShopAttend(ShopAttendSaveRequest req) throws DataRunException;

    /**
     * 查询商家出勤表
     *
     * @param sid
     * @return
     */
    public List<BusiShopAttend> getShopAttendByShopId(long sid, long attendTime);
}
