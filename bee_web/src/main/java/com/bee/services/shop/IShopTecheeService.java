package com.bee.services.shop;

import com.bee.pojo.shop.ShopTechee;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
public interface IShopTecheeService {

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    public List<ShopTechee> getShopTecheeByGroupId(long gid);

    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    public List<ShopTechee> getShopTecheeByShopId(long shopId);

    /**
     * 保存一个技师
     *
     * @param shopTechee
     * @throws DataRunException
     */
    public void saveShopTechee(ShopTechee shopTechee) throws DataRunException;
}
