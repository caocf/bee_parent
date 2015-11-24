package com.bee.services.shop.impl;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.dao.shop.ShopImageDao;
import com.bee.image.ImageFileNameGenerate;
import com.bee.image.ImageParser;
import com.bee.image.ShopImageParser;
import com.bee.image.impl.ShopPhotoListImage;
import com.bee.modal.ShopImageListItem;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.IShopImageService;
import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.commons.utils.ImageUtils;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
