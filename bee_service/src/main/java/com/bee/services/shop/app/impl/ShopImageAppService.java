package com.bee.services.shop.app.impl;

import com.bee.dao.shop.app.ShopImageAppDao;
import com.bee.domain.modal.app.shop.ShopImage;
import com.bee.domain.params.shop.ShopImageListParam;
import com.bee.modal.ShopImageListItem;
import com.bee.services.shop.app.IShopImageAppService;
import com.bee.services.shop.impl.ShopImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopImageAppService extends ShopImageService implements IShopImageAppService {

    @Autowired
    private ShopImageAppDao shopImageAppDao;

    /**
     *
     * @param sid
     * @return
     */
    @Override
    public List<ShopImage> queryShopImage(long sid) {
        ShopImageListParam param = new ShopImageListParam();
        param.setShopId(sid);
        return shopImageAppDao.queryShopImage(param);
    }
}
