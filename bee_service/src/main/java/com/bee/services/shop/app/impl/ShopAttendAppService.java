package com.bee.services.shop.app.impl;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.dao.shop.app.ShopAttendAppDao;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.services.shop.app.IShopAttendAppService;
import com.bee.services.shop.impl.ShopAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
@Service
public class ShopAttendAppService extends ShopAttendService implements IShopAttendAppService {

    @Autowired
    private ShopAttendAppDao shopAttendAppDao;

    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    @Override
    public List<ShopAttend> getShopAttendByShopId(long sid) {
        long time = getAttendTime(System.currentTimeMillis());
        return shopAttendAppDao.getShopAttendByShopId(sid, time);
    }

}
