package com.bee.services.shop.admin.impl;

import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.admin.IShopTecheeAdminService;
import com.bee.services.shop.impl.ShopTecheeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 16/4/17.
 */
@Service
public class ShopTecheeAdminService extends ShopTecheeService implements IShopTecheeAdminService {

    /**
     * 根据分组查询商家技师信息
     *
     * @param groupId
     * @return
     */
    @Override
    public List<ShopTechee> queryShopTecheeByGroup(Long groupId) {
        return shopTecheeDao.queryShopTecheeByGroup(groupId);
    }
}
