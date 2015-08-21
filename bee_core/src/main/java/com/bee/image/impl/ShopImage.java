package com.bee.image.impl;

import com.bee.image.ImageParser;
import com.bee.pojo.Image;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by suntongwei on 15/8/21.
 */
public class ShopImage  extends ImageParser {

    public static final String SHOP_ID = "shopId";

    /**
     * @see com.bee.image.ImageParser
     * @param request
     * @param file
     */
    @Override
    public Image generate(HttpServletRequest request, MultipartFile file) {

        try {

            // 获取商家ID
            Long shopId = Long.valueOf(request.getAttribute(SHOP_ID).toString());

            // 创建网络路径
            String netPath = genShopImageFilePath(shopId);
            // 创建本地路径
            String diskPath = getDiskPath(request, netPath);
            mkdirs(diskPath);

            // 文件名
            String fileName = "face_720.jpg";

            // 创建文件
            // 720p
            File f = new File(diskPath + File.separator + fileName);
            ImageUtils.zoomImage(750, 460, file, f);

            // 创建图片类
            Image image = new Image();
            image.setPath(f.getAbsolutePath());
            image.setUrl(netPath + File.separator + fileName);
            image.setCreateTime(System.currentTimeMillis());
            image.setWidth(750);
            image.setHeight(460);

            return image;

        } catch (RuntimeException e) {
            Log.error(e.getMessage(), e);
            return null;
        }

    }

    @Override
    public void parser() {

    }


    /**
     * 生成该图片文件目录名
     * 生成规则: /shop/shop_{shopId}
     *
     * @param shopId 店名ID
     * @return
     */
    private String genShopImageFilePath(Long shopId) {
        return File.separator + "static" + File.separator + "shop" + File.separator + "shop_" + shopId;
    }
}
