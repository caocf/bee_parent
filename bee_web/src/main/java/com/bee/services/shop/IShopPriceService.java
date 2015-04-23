package com.bee.services.shop;

import com.bee.pojo.shop.ShopPrice;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
public interface IShopPriceService {

    /**
     * 增加商户价格
     *
     * @param shopPrice
     * @throws DataRunException
     */
    public void addShopPrice(ShopPrice shopPrice) throws DataRunException;

    /**
     * 商家价格列表
     *
     * @param sid
     * @return
     */
    public List<ShopPrice> queryShopPriceByShopId(long sid);

    /**
     * 根据ID获取商家价格
     *
     * @param id
     * @return
     */
    public ShopPrice getShopPriceById(long id);

    /**
     * 修改商家价格
     *
     * @param shopPrice
     * @throws DataRunException
     */
    public void updateShopPrice(ShopPrice shopPrice) throws DataRunException;

    /**
     * 根据ID删除商家价格
     *
     * @param id
     * @throws DataRunException
     */
    public void deleteShopPrice(long id) throws DataRunException;
}
