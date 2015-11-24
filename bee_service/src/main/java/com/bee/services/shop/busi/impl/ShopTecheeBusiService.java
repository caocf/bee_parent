package com.bee.services.shop.busi.impl;

import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.pojo.shop.ShopTechee;
import com.bee.services.shop.busi.IShopTecheeBusiService;
import com.bee.services.shop.impl.ShopTecheeService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopTecheeBusiService extends ShopTecheeService implements IShopTecheeBusiService {

    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    public List<BusiShopTechee> getShopTecheeByShopId(long shopId) {
        return shopTecheeDao.getShopTecheeByShopId(shopId);
    }

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
     * 更新一个技师
     *
     * @param shopTechee
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void updateShopTechee(ShopTechee shopTechee) throws DataRunException {
        shopTecheeDao.update(shopTechee);
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
