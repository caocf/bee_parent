package com.bee.services.shop.busi.impl;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.dao.shop.ShopConfigDao;
import com.bee.image.ImageParser;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopConfig;
import com.bee.services.shop.busi.IShopBusiService;
import com.bee.services.shop.impl.ShopService;
import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopBusiService extends ShopService implements IShopBusiService {

    @Autowired
    private ShopConfigDao shopConfigDao;

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

    /**
     * 保存商家宣传视频
     *
     * @param shopId
     * @param req
     */
    @Override
    @Transactional
    public void saveShopVideo(long shopId, MultipartFile file, MultipartHttpServletRequest req)
            throws DataRunException {
        try {
            // 旧的视频版本号
            int oldVideoVer = 0;
            // 获取商家配置数据
            ShopConfig shopConfig = shopConfigDao.getShopConfigByShopId(shopId);
            if (null == shopConfig) {
                shopConfig = shopConfigDao.getDefaultShopConfig(shopId);
            }
            shopConfig.setHasVideo(Consts.True);
            oldVideoVer = shopConfig.getVideoVer();
            shopConfig.setVideoVer(oldVideoVer + 1);
            shopConfigDao.update(shopConfig);

            String path;
            // 旧文件路径
            if (!Consts.isDebug) {
                path = Consts.GetRemoteVideoFilePath() + File.separator + shopId + "_" + oldVideoVer + ".mp4";
            } else {
                path = req.getSession().getServletContext()
                        .getRealPath("video" + File.separator + shopId + "_" + oldVideoVer + ".mp4");
            }
            File oldFile = new File(path);
            // 判断之前视频文件是否存在
            if (oldFile.exists()) {
                oldFile.delete();
            }
            // 创建新的路径
            if (!Consts.isDebug) {
                path = Consts.GetRemoteVideoFilePath() + File.separator + shopId + "_" + (oldVideoVer + 1) + ".mp4";
            } else {
                path = req.getSession().getServletContext()
                        .getRealPath("video" + File.separator + shopId + "_" + (oldVideoVer + 1) + ".mp4");
            }

            // 保存文件
            FileUtil.copy(file.getInputStream(), new File(path));

        } catch (IOException e) {
            throw new DataRunException(Codes.Shop.ShopVideoError, "视频保存失败");
        }
    }
}
