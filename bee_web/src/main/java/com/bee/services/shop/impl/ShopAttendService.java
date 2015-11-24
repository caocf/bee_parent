package com.bee.services.shop.impl;

import com.bee.app.model.shop.ShopAttendItem;
import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.params.shop.ShopAttendSaveRequest;
import com.bee.dao.shop.ShopAttendDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopAttend;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopAttendService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Service
public class ShopAttendService implements IShopAttendService {

    @Autowired
    private ShopAttendDao shopAttendDao;


    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    @Override
    public List<ShopAttendItem> getAppShopAttendByShopId(long sid) {
        long time = getAttendTime(System.currentTimeMillis());
        return shopAttendDao.getAppShopAttendByShopId(sid, time);
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
