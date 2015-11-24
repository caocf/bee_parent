package com.bee.services.shop.busi.impl;

import com.bee.image.ImageParser;
import com.bee.pojo.shop.Shop;
import com.bee.services.shop.busi.IShopBusiService;
import com.bee.services.shop.impl.ShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopBusiService extends ShopService implements IShopBusiService {

    /**
     *
     * @param shop
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void closeShop(Shop shop) throws DataRunException {
        shopDao.update(shop);
    }

    /**
     *
     * @param shopId
     * @param req
     */
    @Override
    public void saveShopListImage(long shopId, MultipartHttpServletRequest req) {
        MultipartFile thumFile = req.getFile("thumbnailFile");
        if (thumFile != null && thumFile.getSize() > 0) {
            req.setAttribute("shopId", shopId);
            ImageParser.getImageParser(ImageParser.ImageType.ShopListThum).generate(req, thumFile);
        }
    }

    /**
     *
     * @param shopId
     * @param req
     */
    @Override
    public void saveShopImage(long shopId, MultipartHttpServletRequest req) {
        MultipartFile file = req.getFile("file");
        if (file != null && file.getSize() > 0) {
            req.setAttribute("shopId", shopId);
            ImageParser.getImageParser(ImageParser.ImageType.ShopImage).generate(req, file);
        }
    }
}
