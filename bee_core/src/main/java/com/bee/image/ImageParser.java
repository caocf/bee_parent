package com.bee.image;

import com.bee.image.impl.ShopImage;
import com.bee.image.impl.ShopListImage;
import com.bee.image.impl.ShopPhotoListImage;
import com.bee.image.impl.ShopRecommendImage;
import com.bee.pojo.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 图片解析抽象父类
 *
 *
 * Created by suntongwei on 15/8/21.
 */
public abstract class ImageParser implements ImageFileNameGenerate {

    protected static final Logger Log = LoggerFactory.getLogger(ImageParser.class);

    /**
     * 图片原始比例
     */
    public static final int ImageSizeAuto = 0;

    /**
     * 图片文件名生成器
     */
    private ImageFileNameGenerate mImageFileNameGenerate;

    /**
     * 图片类型枚举类
     */
    public enum ImageType {
        ShopListThum, ShopImage, ShopRecommend, ShopPhoto
    }

    /**
     * 图片文件扩展名枚举类
     */
    public enum ImageTypeEnum {

        JPG(".jpg"), JPEG(".jpeg"), PNG(".png");

        private String extension;
        private ImageTypeEnum(String extension) {
            this.extension = extension;
        }

        @Override
        public String toString() {
            return extension;
        }
    }

    /**
     *
     * @param type
     * @return
     */
    public static ImageParser getImageParser(ImageType type) {
        ImageParser parser = null;
        switch (type) {
            case ShopListThum:
                parser = new ShopListImage();
                break;
            case ShopImage:
                parser = new ShopImage();
                break;
            case ShopRecommend:
                parser = new ShopRecommendImage();
                break;
            case ShopPhoto:
                parser = new ShopPhotoListImage();
                break;
        }
        return parser;
    }

    /**
     * 生成图片
     * 保存到本地路径和TB_IMAGE，调用该类需要加入事务处理，需要保存TB_IMAGE类
     *
     * @param request
     * @param file
     * @return String[] 0：网络路径，1：本地路径
     */
    public abstract String[] generate(HttpServletRequest request, MultipartFile file);

    /**
     * 解析图片
     */
    public abstract void parser();


    /**
     * 返回本地磁盘绝对路径
     *
     * @param request
     * @param p
     * @return
     */
    public String getDiskPath(HttpServletRequest request, String p) {
        // 本地磁盘路径
        return request.getSession().getServletContext().getRealPath(p);
    }

    /**
     * 返回网络路径
     *
     * @param p
     * @return
     */
    public String getNetPath(String p) {
        return File.separator + "static" + File.separator + p;
    }

    /**
     * 创建目录
     *
     * @param path
     */
    public void mkdirs(String path) throws RuntimeException {

        // 创建文件
        File file = new File(path);

        // 判断是否存在
        if (file.exists()) {
            return;
        }

        // 创建目录
        file.mkdirs();
    }

    /**
     * 返回ImageFileNameGenerate
     *
     * @return
     */
    public ImageFileNameGenerate getImageFileNameGenerate() {
        if (null == mImageFileNameGenerate) {
            return this;
        }
        return mImageFileNameGenerate;
    }

    public void setImageFileNameGenerate(ImageFileNameGenerate l) {
        mImageFileNameGenerate = l;
    }


    /**
     * 默认文件名返回
     *
     * @return
     */
    @Override
    public String getFileName(HttpServletRequest request) {
        return System.currentTimeMillis() + ImageTypeEnum.JPG.toString();
    }
}
