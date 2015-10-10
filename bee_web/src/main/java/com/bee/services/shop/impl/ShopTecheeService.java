package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopTecheeDao;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.IShopTecheeService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Service
public class ShopTecheeService implements IShopTecheeService {

    @Autowired
    private ShopTecheeDao shopTecheeDao;

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    @Override
    public List<ShopTechee> getShopTecheeByGroupId(long gid) {
        return shopTecheeDao.getShopTecheeByGroupId(gid);
    }


    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    public List<ShopTechee> getShopTecheeByShopId(long shopId) {
        return shopTecheeDao.getShopTecheeByShopId(shopId);
    }


    /**
     * 保存一个技师
     *
     * @param shopTechee
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    public void saveShopTechee(ShopTechee shopTechee) throws DataRunException {
        shopTecheeDao.save(shopTechee);
    }
}
