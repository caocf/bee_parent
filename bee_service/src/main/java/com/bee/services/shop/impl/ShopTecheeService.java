package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopTecheeDao;
import com.bee.dao.shop.ShopUpdateDao;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.pojo.shop.ShopUpdate;
import com.bee.services.shop.IShopTecheeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopTecheeService implements IShopTecheeService {

    @Autowired
    protected ShopTecheeDao shopTecheeDao;
    @Autowired
    protected ShopUpdateDao shopUpdateDao;

    /**
     * 当商家技师信息发生改变
     */
    protected void changeShopTechee(Long shopId) {
        ShopUpdate shopUpdate = shopUpdateDao.getShopUpdateByShopId(shopId);
        if (null == shopUpdate) {
            shopUpdate = shopUpdateDao.create(shopId);
        }
        shopUpdate.setUpdateTechee(System.currentTimeMillis());
        shopUpdateDao.update(shopUpdate);
    }

    /**
     * 查询商家技师出勤表
     *
     * @param sid 商家ID
     * @return
     */
    @Override
    public List<ShopTecheeAttend> queryShopTecheeAttend(Long sid) {
        return shopTecheeDao.queryShopTecheeAttend(sid);
    }

}
