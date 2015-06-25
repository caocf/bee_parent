package com.bee.services.shop.impl;

import com.bee.commons.Consts;
import com.bee.dao.shop.ShopErrorDao;
import com.bee.pojo.shop.ShopError;
import com.bee.services.shop.IShopErrorService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/6/26.
 */
@Service
public class ShopErrorService implements IShopErrorService {

    @Autowired
    private ShopErrorDao shopErrorDao;

    @Override
    @Transactional
    public void addShopError(ShopError shopError) throws DataRunException {
        shopError.setCreateTime(System.currentTimeMillis());
        shopError.setStatus(Consts.Shop.ErrorStatus.New);
        shopErrorDao.save(shopError);
    }
}
