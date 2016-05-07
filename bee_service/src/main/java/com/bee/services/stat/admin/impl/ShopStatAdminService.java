package com.bee.services.stat.admin.impl;

import com.bee.domain.modal.admin.stat.ShopCountStat;
import com.bee.services.stat.admin.IShopStatAdminService;
import com.bee.services.stat.impl.ShopStatService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by suntongwei on 16/5/7.
 */
@Service
public class ShopStatAdminService extends ShopStatService implements IShopStatAdminService {

    /**
     *
     *
     * @return
     */
    @Override
    public List<ShopCountStat> statShopVisitCount() {
        return shopStatDao.statShopVisitCount(System.currentTimeMillis() - (DateUtil.ONE_DAY_TIME * 30));
    }

    /**
     *
     * @param time 该时间之前的数据全部删除
     */
    @Override
    @Transactional
    public void mateShopStat(long time) throws DataRunException {
        shopStatDao.mateShopStat(time);
    }
}
