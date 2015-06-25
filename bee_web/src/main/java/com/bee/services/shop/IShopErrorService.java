package com.bee.services.shop;

import com.bee.pojo.shop.ShopError;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/6/26.
 */
public interface IShopErrorService {


    public void addShopError(ShopError shopError) throws DataRunException;

}
