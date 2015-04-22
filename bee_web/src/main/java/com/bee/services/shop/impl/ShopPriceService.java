package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopPriceDao;
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
            shopPriceDao.save(shopPrice);

            Double minPrice = null;
            List<ShopPrice> shopPriceList = shopPriceDao.queryShopPriceByShopId(shopPrice.getShop().getSid());
            for(ShopPrice price : shopPriceList) {
                if(null == minPrice) {
                    minPrice = price.getPrice();
                } else {
                    if(price.getPrice() != null && price.getPrice() < minPrice) {
                        minPrice = price.getPrice();
                    }
                }
            }

            Shop shop = shopDao.getShopById(shopPrice.getShop().getSid());
            shop.setPrice(minPrice);
            shopDao.save(shop);
        } catch (DataRunException e) {
            throw e;
        }
    }
}
