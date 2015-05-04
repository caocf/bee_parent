package com.bee.commons;

import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by suntongwei on 15/4/23.
 */
public class ImageFactory {

    public enum ImageType {
        ShopListSize, ShopMainSize, ShopAdSize, PartyAdSize
    }

    // 商家列表缩略图
    public static final int[][] ShopListSize = new int[][]{
            new int[]{160, 160} // 720
    };

    // 商家详细大图
    public static final int[][] ShopMainSize = new int[][]{
            new int[]{750, 360} // 720
    };

    // 首页广告尺寸
    public static final int[][] ShopAdSize = new int[][]{
            new int[]{750, 288} // 720
    };

    // 活动广告尺寸
    public static final int[][] PartyAdSize = new int[][]{
            new int[]{750, 293} // 720
    };

    /**
     * <p>保存图片</p>
     * <b>文件名规则</b> /file/{fileName}/{fileName}_{width}x{height}.jpg
     *
     * @param request
     * @param mFile
     * @return 返回图片的文件目录 /{fileName}
     */
    public synchronized String[] saveImage(ImageType imageType, HttpServletRequest request, MultipartFile mFile) {

        // 创建该图片基础名和目录
        String fileName = String.valueOf(System.currentTimeMillis());
        // 创建图片文件夹路径
        String p = File.separator + "static" + File.separator + fileName;
        // 本地磁盘路径
        String path = request.getSession().getServletContext().getRealPath(p);
        // 创建目录
        new File(path).mkdirs();

        int[][] sizes = new int[0][0];
        if (ImageType.ShopListSize == imageType) {
            sizes = ShopListSize;
        } else if (ImageType.ShopMainSize == imageType) {
            sizes = ShopMainSize;
        } else if (ImageType.ShopAdSize == imageType) {
            sizes = ShopAdSize;
        } else if (ImageType.PartyAdSize == imageType) {
            sizes = PartyAdSize;
        }

        String filePath = "";
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            filePath = path + File.separator + "p_" + size[0] + "x" + size[1] + ".jpg";
            ImageUtils.zoomImage(size[0], size[1], mFile, new File(filePath));
        }
        return new String[]{p, path};
    }


    /**
     * 删除本地图片
     *
     * @param path
     * @return
     */
    public synchronized void deleteImage(String path) {
        FileUtil.deleteFile(new File(path));
    }

    /**
     * Image 封装类
     * 主要为了解决多尺寸图片
     */
    public static class Image implements java.io.Serializable {

        // serialVersionUID
        private static final long serialVersionUID = -1371594730533288737L;

        // 750图片路径
        private String path720;

        // 构造方法
        public Image(String path, ImageType type) {
            if (ImageType.ShopListSize == type) {
                this.path720 =
                        path + File.separator + "p_" + ShopListSize[0][0] + "x" + ShopListSize[0][1] + ".jpg";
            } else if (ImageType.PartyAdSize == type) {
                this.path720 =
                        path + File.separator + "p_" + PartyAdSize[0][0] + "x" + PartyAdSize[0][1] + ".jpg";
            } else if (ImageType.ShopAdSize == type) {
                this.path720 =
                        path + File.separator + "p_" + ShopAdSize[0][0] + "x" + ShopAdSize[0][1] + ".jpg";
            } else if (ImageType.ShopMainSize == type) {
                this.path720 =
                        path + File.separator + "p_" + ShopMainSize[0][0] + "x" + ShopMainSize[0][1] + ".jpg";
            }
        }

        public String getPath720() {
            return path720;
        }
    }

    private static ImageFactory ourInstance = new ImageFactory();

    public static ImageFactory getInstance() {
        return ourInstance;
    }

    private ImageFactory() {
    }
}
