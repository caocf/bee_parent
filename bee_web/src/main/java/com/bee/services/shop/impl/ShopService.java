package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopListRequest;
import com.bee.dao.shop.ShopDao;
import com.bee.image.ImageParser;
import com.bee.modal.ShopItem;
import com.bee.modal.ShopListItem;
import com.bee.modal.ShopMap;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopDao shopDao;

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<ShopListItem> queryAppShopList(ShopListRequest req) {
        return shopDao.queryAppShopList(req);
    }

    /**
     *
     * @param uid
     * @return
     */
    @Override
    public List<ShopListItem> queryRecommendShop(long uid) {
        return shopDao.queryRecommendShop(uid);
    }

    /**
     *
     * @param sid
     * @return
     */
    @Override
    public ShopItem getShopItemById(long sid) {
        return shopDao.getShopItemById(sid);
    }


    /**
     *
     * @return
     */
    @Override
    public List<ShopMap> queryShopMapAll() {
        return shopDao.queryShopMapAll();
    }
}
