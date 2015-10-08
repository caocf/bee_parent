package com.bee.services.shop.impl;

import com.bee.busi.model.shop.BusiShopAttend;
import com.bee.busi.params.shop.ShopAttendSaveRequest;
import com.bee.dao.shop.ShopAttendDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopAttend;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopAttendService;
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
     * 保存商家出勤表
     *
     * @param req
     */
    @Override
    @Transactional
    public void saveShopAttend(ShopAttendSaveRequest req) throws DataRunException {
        List<ShopAttend> shopAttendList = new ArrayList<>();
        for (Long id : req.getTecheeIds()) {
            ShopAttend item = new ShopAttend();
            item.setShopTechee(new ShopTechee(id));
            item.setAttendTime(getAttendTime(req.getAttendTime()));
            item.setShop(new Shop(req.getShopId()));
            shopAttendList.add(item);
        }

        shopAttendDao.saveAll(shopAttendList);
    }


    /**
     * 查询商家出勤表
     *
     * @param sid
     * @return
     */
    public List<BusiShopAttend> getShopAttendByShopId(long sid, long attendTime) {
        return shopAttendDao.getShopAttendByShopId(sid, getAttendTime(attendTime));
    }


    private Long getAttendTime(long attendTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(attendTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
