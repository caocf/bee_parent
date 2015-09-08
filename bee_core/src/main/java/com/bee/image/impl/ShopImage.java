package com.bee.image.impl;

import com.bee.image.ShopImageParser;
import com.bee.pojo.Image;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by suntongwei on 15/8/21.
 */
public class ShopImage extends ShopImageParser {

    /**
     * @see com.bee.image.ImageParser
     * @param request
     * @param file
     */
    @Override
    public String[] generate(HttpServletRequest request, MultipartFile file) {

        try {

            // 获取商家ID
            Long shopId = Long.valueOf(request.getAttribute(SHOP_ID).toString());

            // 创建网络路径
            String netPath = genShopImageFilePath(shopId);
            // 创建本地路径
            String diskPath = getDiskPath(request, netPath);
            mkdirs(diskPath);

            // 文件名
            String fileName = getImageFileNameGenerate().getFileName(request);
            // 创建文件
            // 720p
            File f = new File(diskPath + File.separator + fileName);
            ImageUtils.getBufferedImage(file);
            ImageUtils.zoomImage(750, 460, file, f);

            return new String[] {
                    netPath + File.separator + fileName,
                    diskPath + File.separator + fileName
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

    @Override
    public String getFileName(HttpServletRequest request) {
        return "face_720" + ImageTypeEnum.JPG.toString();
    }
}
