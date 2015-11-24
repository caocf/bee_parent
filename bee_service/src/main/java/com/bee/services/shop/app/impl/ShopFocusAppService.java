package com.bee.services.shop.app.impl;

import com.bee.dao.shop.app.ShopFocusAppDao;
import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.domain.params.shop.ShopFocusListParam;
import com.bee.services.shop.app.IShopFocusAppService;
import com.bee.services.shop.impl.ShopFocusService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/17.
 */
@Service
public class ShopFocusAppService extends ShopFocusService implements IShopFocusAppService {

    @Autowired
    private ShopFocusAppDao shopFocusAppDao;

    /**
     * 返回用户所有关注商户
     *
     * @return
     */
    public PagingResult<ShopFavorite> getShopFocusListByParam(ShopFocusListParam param) {
        return shopFocusAppDao.getShopFocusListByParam(param);
    }
}
