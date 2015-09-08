package com.bee.image.impl;

import com.bee.image.ImageParser;
import com.bee.image.ShopImageParser;
import com.bee.pojo.Image;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by suntongwei on 15/8/22.
 */
public class ShopRecommendImage extends ShopImageParser {

    /**
     * @param request
     * @param file
     * @see com.bee.image.ImageParser
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

            String fileName = getImageFileNameGenerate().getFileName(request);

            // 创建文件
            // 720p
            File f = new File(diskPath + File.separator + fileName);
            ImageUtils.zoomImage(210, 300, file, f);

            return new String[] {
                    netPath + File.separator + fileName,
                    diskPath + File.separator + fileName
            };

        } catch (RuntimeException e) {
            Log.error(e.getMessage(), e);
            return null;
        }

    }

    @Override
    public void parser() {

    }


    @Override
    public String getFileName(HttpServletRequest request) {
        return "recommend_720" + ImageTypeEnum.JPG.toString();
    }
}