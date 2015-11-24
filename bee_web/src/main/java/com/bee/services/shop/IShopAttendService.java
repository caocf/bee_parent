package com.bee.services.shop;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.params.shop.ShopAttendSaveRequest;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
public interface IShopAttendService {


    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    public List<ShopAttendItem> getAppShopAttendByShopId(long sid);

}
