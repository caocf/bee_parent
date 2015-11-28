package com.bee.services.shop.app.impl;

import com.bee.dao.shop.app.ShopAttendAppDao;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.services.shop.app.IShopAttendAppService;
import com.bee.services.shop.impl.ShopAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b>商家出勤表APP</b>
 */
@Service
public class ShopAttendAppService extends ShopAttendService implements IShopAttendAppService {

    @Autowired
    private ShopAttendAppDao shopAttendAppDao;

    /**
     *【C端】查询商家出勤表
     *
     * v1.0.5调整策略
     * 改变原先获取每天的出勤表,改为获取最近的出勤表
     * 如果商家从未上传过出勤表,则返回null
     *
     * @param sid
     * @return
     */
    @Override
    public List<ShopAttend> getShopAttendByShopId(long sid) {
        Long time = shopAttendAppDao.getShopAttendLastUpdateTime(sid);
        if (null == time) {
            return null;
        }
        return shopAttendAppDao.getShopAttendByShopId(sid, time);
    }

}
