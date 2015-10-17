package com.bee.services.shop.impl;

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
     * 保存商家出勤表
     *
     * @param req
     */
    @Override
    @Transactional
    public void saveShopAttend(ShopAttendSaveRequest req) throws DataRunException {
        try {
            // 保存前先删除出勤记录
            deleteShopAttend(req.getShopId(), req.getAttendTime());

            // 保存数据
            List<ShopAttend> shopAttendList = new ArrayList<>();
            String[] ids = req.getTecheeIds().split(",");
            for (String id : ids) {
                ShopAttend item = new ShopAttend();
                item.setShopTechee(new ShopTechee(Long.valueOf(id)));
                item.setAttendTime(req.getAttendTime());
                item.setShop(new Shop(req.getShopId()));
                shopAttendList.add(item);
            }
            shopAttendDao.saveAll(shopAttendList);

        } catch (DataRunException e) {
            throw e;
        }
    }


    /**
     * 查询商家出勤表
     *
     * @param sid
     * @return
     */
    @Override
    public List<BusiShopAttend> getShopAttendByShopId(long sid, long attendTime) {
        return shopAttendDao.getShopAttendByShopId(sid, getAttendTime(attendTime));
    }


    /**
     * 查询商家出勤表，大于查询时间
     *
     * @param sid
     * @param attendTime
     * @return
     */
    public List<BusiShopAttend> getShopAttendByShopIdAfter(long sid, long attendTime) {
        return shopAttendDao.getShopAttendByShopIdAfter(sid, getAttendTime(attendTime));
    }


    /**
     * 根据时间删除出勤表
     *
     * @param attendTime
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShopAttend(long sid, long attendTime) throws DataRunException {
        shopAttendDao.deleteShopAttend(sid, attendTime);
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
