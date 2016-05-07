package com.bee.services.stat.admin;

import com.bee.domain.modal.admin.stat.ShopCountStat;
import com.bee.services.stat.IShopStatService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 16/5/7.
 */
public interface IShopStatAdminService extends IShopStatService {

    /**
     * 统计商家游览次数
     *
     * @return ShopCountStat
     */
    List<ShopCountStat> statShopVisitCount();

    /**
     * 清理维护TB_SHOP_STAT
     */
    void mateShopStat(long time) throws DataRunException;

}
