package com.bee.services.shop.admin;

import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopTecheeService;

import java.util.List;

/**
 * Created by suntongwei on 16/4/17.
 */
public interface IShopTecheeAdminService extends IShopTecheeService {

    /**
     * 根据分组查询商家技师信息
     *
     * @param groupId
     * @return
     */
    List<ShopTechee> queryShopTecheeByGroup(Long groupId);
}
