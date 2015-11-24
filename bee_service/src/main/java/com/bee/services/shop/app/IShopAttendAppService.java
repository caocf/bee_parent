package com.bee.services.shop.app;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.services.shop.IShopAttendService;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
public interface IShopAttendAppService extends IShopAttendService {

    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    public List<ShopAttend> getShopAttendByShopId(long sid);
}
