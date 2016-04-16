package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopTecheeDao;
import com.bee.dao.shop.ShopUpdateDao;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.pojo.shop.ShopTechee;
import com.bee.pojo.shop.ShopUpdate;
import com.bee.services.shop.IShopTecheeService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
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
     * 查询商家技师出勤表
     *
     * @param sid 商家ID
     * @return
     */
    @Override
    public List<ShopTecheeAttend> queryShopTecheeAttend(Long sid) {
        return shopTecheeDao.queryShopTecheeAttend(sid);
    }

    /**
     * 保存一个技师
     *
     * @param shopTechee
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void saveShopTechee(ShopTechee shopTechee) throws DataRunException {
        shopTecheeDao.save(shopTechee);
    }

    /**
     * 删除一个技师
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShopTechee(long id) throws DataRunException {
        shopTecheeDao.deleteById(id);
    }
}
