package com.bee.services.shop.busi.impl;

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
    public void saveShopVideo(long shopId, MultipartFile file, MultipartHttpServletRequest req) {
        try {
            String path;
            if (!Consts.isDebug) {
                path = Consts.GetRemoteVideoFilePath() + File.separator + shopId + ".mp4";
            } else {
                path = req.getSession().getServletContext()
                        .getRealPath("video" + File.separator + shopId + ".mp4");
            }
            // 保存文件
            FileUtil.copy(file.getInputStream(), new File(path));
            // 更新该商家配置信息
            ShopConfig shopConfig = shopConfigDao.getShopConfigByShopId(shopId);
            if (null == shopConfig) {
                shopConfig = shopConfigDao.getDefaultShopConfig(shopId);
            }
            shopConfig.setHasVideo(Consts.True);
            shopConfigDao.update(shopConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
