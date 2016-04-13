package com.bee.services.shop;

import com.bee.domain.modal.app.shop.ShopTecheeAttend;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopTecheeService {

    /**
     * 查询商家技师出勤表
     *
     * @param sid 商家ID
     * @return
     */
    List<ShopTecheeAttend> queryShopTecheeAttend(Long sid);
}
