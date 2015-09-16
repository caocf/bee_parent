package com.bee.image.impl;

import com.bee.image.ShopImageParser;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by suntongwei on 15/9/7.
 */
public class ShopPhotoListImage extends ShopImageParser {


    public static final String FILENAME_SUFFIX = "ShopPhotoSuffix";


    @Override
    public String[] generate(HttpServletRequest request, MultipartFile file) {
        try {

            // 获取商家ID
            Long shopId = Long.valueOf(request.getAttribute(SHOP_ID).toString());

            // fileNameTime为文件名时间戳
            String fileNameTime = String.valueOf(System.currentTimeMillis());

            // 创建网络路径
            String netPath = genShopImageFilePath(shopId) + File.separator + fileNameTime;
            // 创建本地路径
            String diskPath = getDiskPath(request, netPath);
            mkdirs(diskPath);

            // 获取图片原始大小尺寸
            BufferedImage bufferedImage = ImageUtils.getBufferedImage(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();

            // 原始比例
            String fileNameAuto = "auto" + ImageTypeEnum.JPG.toString();
            File fileAuto = new File(diskPath + File.separator + fileNameAuto);
            ImageUtils.zoomImage(ImageSizeAuto, ImageSizeAuto, file, fileAuto);

            // 缩略图,缩小3倍
            String fileNameThum = "thum" + ImageTypeEnum.JPG.toString();
            File fileThum = new File(diskPath + File.separator + fileNameThum);
            ImageUtils.zoomImage(-3, -3, file, fileThum);

            /**
             * 返回无后缀路径
             */
            return new String[] {
                    netPath, diskPath, String.valueOf(width), String.valueOf(height)
            };

        } catch (RuntimeException e) {
            Log.error(e.getMessage(), e);
        } catch (IOException e) {
            Log.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void parser() {

    }

}
