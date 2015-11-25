package com.bee.services.shop.impl;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.shop.ShopImageDao;
import com.bee.dao.shop.app.ShopImageAppDao;
import com.bee.domain.modal.app.shop.ShopImage;
import com.bee.domain.params.shop.ShopImageListParam;
import com.bee.services.shop.IShopImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
@Service
public class ShopImageService implements IShopImageService {

    @Autowired
    private ShopImageAppDao shopImageDao;

    @Override
    public List<ShopImage> queryAppShopImage(long sid) {
        ShopImageListParam param = new ShopImageListParam();
        param.setShopId(sid);
        return shopImageDao.queryShopImage(param);
    }



    /**
     * 返回图片类型
     * 2015.9.7 删除该方法，取消图片类型，该类保存所有图片均为商家相册图片
     *
     * @param type
     * @return
     */
    @Deprecated
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
