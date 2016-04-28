package com.bee.services.shop.admin;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.shop.ShopConfig;
import com.bee.services.shop.IShopConfigService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 16/4/29.
 */
public interface IShopConfigAdminService extends IShopConfigService {

    /**
     * 查询商家配置
     *
     * @return
     */
    PagingResult<ShopConfig> queryShopConfigList(AdminRequestPaging param);
}
