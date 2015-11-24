package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopAttendDao;
import com.bee.services.shop.IShopAttendService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopAttendService implements IShopAttendService {

    @Autowired
    protected ShopAttendDao shopAttendDao;

    /**
     *
     * @param attendTime
     * @return
     */
    public Long getAttendTime(long attendTime) {
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
