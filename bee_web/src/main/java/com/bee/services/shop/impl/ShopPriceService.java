package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopPriceDao;
import com.bee.modal.ShopPriceItem;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopPrice;
import com.bee.services.shop.IShopPriceService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/4/16.
 */
@Service
public class ShopPriceService implements IShopPriceService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ShopPriceDao shopPriceDao;

    @Override
    @Transactional
    public void addShopPrice(ShopPrice shopPrice) throws DataRunException {
        try {
            if (null == shopPrice.getSort()) {
                shopPrice.setSort(100);
            }
            if (null == shopPrice.getTitle() || "".equals(shopPrice.getTitle())) {
                shopPrice.setTitle("");
            }
            if (null == shopPrice.getShop()) {
                shopPrice.setShop(new Shop(0l));
            }
            shopPriceDao.save(shopPrice);
            updatePriceForShop(shopPrice.getPrice(), shopPrice.getShop().getSid());
        } catch (DataRunException e) {
            throw e;
        }
    }

    @Override
    public List<ShopPriceItem> queryAppShopPriceByShopId(long sid) {
        return shopPriceDao.queryAppShopPriceByShopId(sid);
    }

    @Override
    public List<ShopPrice> queryShopPriceByShopId(long sid) {
        return shopPriceDao.queryShopPriceByShopId(sid);
    }

    @Override
    public ShopPrice getShopPriceById(long id) {
        return shopPriceDao.getShopPriceById(id);
    }

    @Override
    @Transactional
    public void updateShopPrice(ShopPrice shopPrice) throws DataRunException {
        try {
            shopPriceDao.update(shopPrice);
            updatePriceForShop(shopPrice.getPrice(), shopPrice.getShop().getSid());
        } catch(DataRunException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteShopPrice(long id) throws DataRunException {
        try {
            ShopPrice shopPrice = shopPriceDao.getShopPriceById(id);
            shopPriceDao.delete(shopPrice);
            updatePriceForShop(shopPrice.getPrice(), shopPrice.getShop().getSid());
        } catch(DataRunException e) {
            throw e;
        }
    }

    /**
     * 更新价格
     *
     * @param p
     * @param sid
     */
    private void updatePriceForShop(double p, long sid) {
        Shop shop = shopDao.findById(sid);
        if(null == shop.getPrice() || p <= shop.getPrice() || shop.getPrice() <= 0) {
            Double minPrice = null;
            List<ShopPrice> shopPriceList = shopPriceDao.queryShopPriceByShopId(sid);
            for(ShopPrice price : shopPriceList) {
                if(null == minPrice) {
                    minPrice = price.getPrice();
                } else {
                    if(price.getPrice() != null && price.getPrice() < minPrice) {
                        minPrice = price.getPrice();
                    }
                }
            }
            shop.setPrice(minPrice);
            shopDao.save(shop);
        }
    }
}
