package com.bee.services.shop.impl;

import com.bee.commons.ImageFactory;
import com.bee.dao.shop.ShopImageDao;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.IShopImageService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
@Service
public class ShopImageService implements IShopImageService {

    @Autowired
    private ShopImageDao shopImageDao;

    @Override
    public List<ShopImage> queryShopImageByShopId(long sid) {
        return shopImageDao.queryShopImageByShopId(sid);
    }

    @Override
    @Transactional
    public void addShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException {
        try {
            String[] paths = ImageFactory.getInstance().saveImage(req, file);
            shopImage.setUrl(paths[0]);
            shopImage.setPath(paths[1]);
            shopImageDao.save(shopImage);
        } catch(DataRunException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delShopImage(long shopImageId) throws DataRunException {
        try {
            ShopImage shopImage = shopImageDao.findById(shopImageId);
            ImageFactory.getInstance().deleteImage(shopImage.getPath());
            shopImageDao.delete(shopImage);
        } catch(DataRunException e) {
            throw e;
        }
    }

    @Override
    public ShopImage getShopImageById(long id) {
        return shopImageDao.getShopImageById(id);
    }

    @Override
    @Transactional
    public void updateShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException {
        try {
            if(!file.isEmpty()) {
                String[] paths = ImageFactory.getInstance().saveImage(req, file);
                shopImage.setUrl(paths[0]);
                shopImage.setPath(paths[1]);
            }
            shopImageDao.update(shopImage);
        } catch(DataRunException e) {
            throw e;
        }
    }
}
