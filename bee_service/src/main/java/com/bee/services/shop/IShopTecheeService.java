package com.bee.services.shop;

import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.pojo.shop.ShopTechee;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopTecheeService {

    /**
     * 查询商家技师出勤表
     *
     * @param sid 商家ID
     * @return
     */
    List<ShopTecheeAttend> queryShopTecheeAttend(Long sid);

    /**
     * 保存一个技师
     *
     * @param shopTechee
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void saveShopTechee(ShopTechee shopTechee) throws DataRunException;

    /**
     * 删除一个技师
     *
     * @param id
     * @throws DataRunException
     */
    void deleteShopTechee(long id) throws DataRunException;
}
