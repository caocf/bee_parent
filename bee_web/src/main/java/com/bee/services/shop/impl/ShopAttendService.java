package com.bee.services.shop.impl;

import com.bee.dao.shop.app.ShopAttendAppDao;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.bee.services.shop.IShopAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Service
public class ShopAttendService implements IShopAttendService {

    @Autowired
    private ShopAttendAppDao shopAttendDao;


    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    @Override
    public List<ShopAttend> getAppShopAttendByShopId(long sid) {
        long time = getAttendTime(System.currentTimeMillis());
        return shopAttendDao.getShopAttendByShopId(sid, time);
    }


    private Long getAttendTime(long attendTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(attendTime);
        cal.set(Calendar.AM_PM, Calendar.AM);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
