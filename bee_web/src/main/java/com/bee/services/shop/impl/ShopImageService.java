package com.bee.services.shop.impl;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.shop.ShopImageDao;
import com.bee.modal.ShopImageListItem;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.IShopImageService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
@Service
public class ShopImageService implements IShopImageService {

    @Autowired
    private ShopImageDao shopImageDao;

    @Override
    public List<ShopImageListItem> queryAppShopImage(long sid) {
        return shopImageDao.queryAppShopImage(sid);
    }

    @Override
    public List<ShopImage> queryShopImageByShopId(long sid) {
        return shopImageDao.queryShopImageByShopId(sid);
    }

    @Override
    @Transactional
    public void addShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException {
        try {
            String[] paths = ImageFactory.getInstance().saveImage(getImageType(shopImage.getType()), req, file);
            shopImage.setUrl(paths[0]);
            shopImage.setPath(paths[1]);
            shopImageDao.save(shopImage);
        } catch (DataRunException e) {
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
        } catch (DataRunException e) {
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
            if (!file.isEmpty()) {
                String[] paths = ImageFactory.getInstance().saveImage(getImageType(shopImage.getType()), req, file);
                shopImage.setUrl(paths[0]);
                shopImage.setPath(paths[1]);
            }
            shopImageDao.update(shopImage);
        } catch (DataRunException e) {
            throw e;
        }
    }

    private ImageFactory.ImageType getImageType(int type) {
        ImageFactory.ImageType imageType = null;
        switch (type) {
            case Consts.Shop.ImageType.Big:
                imageType = ImageFactory.ImageType.ShopListSize;
                break;
            case Consts.Shop.ImageType.Photo:
                imageType = ImageFactory.ImageType.ShopImage;
                break;
        }
        return imageType;
    }
}
