package com.bee.image;

import com.bee.image.impl.ShopListImage;
import com.bee.pojo.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import static com.bee.image.ImageParser.ImageType.*;

/**
 * Created by suntongwei on 15/8/21.
 */
public abstract class ImageParser {

    protected static final Logger Log = LoggerFactory.getLogger(ImageParser.class);


    public enum ImageType {
        ShopListThum
    }


    public static ImageParser getImageParser(ImageType type) {
        ImageParser parser = null;
        switch (type) {
            case ShopListThum:
                parser = new ShopListImage();
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
     */
    public abstract Image generate(HttpServletRequest request, MultipartFile file);

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


}
