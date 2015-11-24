package com.bee.services.shop.admin.impl;

import com.bee.image.ImageParser;
import com.bee.image.ShopImageParser;
import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.admin.IShopImageAdminService;
import com.bee.services.shop.impl.ShopImageService;
import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopImageAdminService extends ShopImageService implements IShopImageAdminService {

    @Override
    public List<ShopImage> queryShopImageByShopId(long sid) {
        return shopImageDao.queryShopImageByShopId(sid);
    }

    @Override
    @Transactional
    public void addShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException {
        try {
            // 2015.9.7 删除原本图片保存方式, 替换为ImageParser
            // String[] paths = ImageFactory.getInstance().saveImage(getImageType(shopImage.getType()), req, file);
            ImageParser parser = ImageParser.getImageParser(ImageParser.ImageType.ShopPhoto);
            req.setAttribute(ShopImageParser.SHOP_ID, shopImage.getShop().getSid());
            String[] paths = parser.generate(req, file);
            shopImage.setUrl(paths[0]);
            shopImage.setPath(paths[1]);
            // 设置宽和高
            shopImage.setWidth(Integer.valueOf(paths[2]));
            shopImage.setHeight(Integer.valueOf(paths[3]));

            shopImage.setType(0);
            if (null == shopImage.getSort()) {
                shopImage.setSort(100);
            }
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
            // ImageFactory.getInstance().deleteImage(shopImage.getPath());
            // 判断原有文件是否存在
            String oldImageDiskPath = shopImage.getPath();
            File oldFile = new File(oldImageDiskPath);
            if (oldFile.exists()) {
                // 删除所有文件
                FileUtil.deleteFile(oldFile);
            }
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
                // 2015.9.8 删除
                // String[] paths = ImageFactory.getInstance().saveImage(getImageType(shopImage.getType()), req, file);

                // 判断原有文件是否存在
                String oldImageDiskPath = shopImage.getPath();
                File oldFile = new File(oldImageDiskPath);
                if (oldFile.exists()) {
                    // 删除所有文件，重新创建
                    FileUtil.deleteFile(oldFile);
                }

                // 创建文件
                ImageParser parser = ImageParser.getImageParser(ImageParser.ImageType.ShopPhoto);
                req.setAttribute(ShopImageParser.SHOP_ID, shopImage.getShop().getSid());
                String[] paths = parser.generate(req, file);
                shopImage.setUrl(paths[0]);
                shopImage.setPath(paths[1]);
                // 设置宽和高
                shopImage.setWidth(Integer.valueOf(paths[2]));
                shopImage.setHeight(Integer.valueOf(paths[3]));
            }
            shopImage.setType(0);
            if (null == shopImage.getSort()) {
                shopImage.setSort(100);
            }
            shopImageDao.update(shopImage);
        } catch (DataRunException e) {
            throw e;
        }
    }
}
