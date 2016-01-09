package com.bee.services.shop.app.impl;

import com.bee.dao.shop.app.ShopFocusAppDao;
import com.bee.domain.modal.app.shop.ShopFavorite;
import com.bee.domain.params.shop.ShopFocusListParam;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopFocus;
import com.bee.pojo.user.User;
import com.bee.services.shop.app.IShopFocusAppService;
import com.bee.services.shop.impl.ShopFocusService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     *
     * @param shopId
     * @param userId
     * @return
     */
    @Override
    public ShopFocus getShopFocusByUser(Long shopId, Long userId) {
        return shopFocusAppDao.getFoucsShop(shopId, userId);
    }

    /**
     * 给用户添加关注
     *
     * @param shopId
     * @param userId
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void addShopFocus(Long shopId, Long userId) throws DataRunException {
        ShopFocus shopFocus = new ShopFocus();
        shopFocus.setUser(new User(userId));
        shopFocus.setShop(new Shop(shopId));
        shopFocus.setCreateTime(System.currentTimeMillis());
        shopFocusDao.save(shopFocus);
    }
}
