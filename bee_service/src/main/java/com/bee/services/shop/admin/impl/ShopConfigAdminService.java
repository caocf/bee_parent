package com.bee.services.shop.admin.impl;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.shop.ShopConfig;
import com.bee.services.shop.admin.IShopConfigAdminService;
import com.bee.services.shop.impl.ShopConfigService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 16/4/29.
 */
@Service
public class ShopConfigAdminService extends ShopConfigService implements IShopConfigAdminService {

    /**
     *
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<ShopConfig> queryShopConfigList(AdminRequestPaging param) {
        return shopConfigDao.queryShopConfig(param);
    }
}
