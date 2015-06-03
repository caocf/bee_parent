package com.bee.commons;

import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by suntongwei on 15/4/23.
 */
public class ImageFactory {

    private static final int Auto = 0;

    public enum ImageType {
        UserImage, ShopListSize, ShopMainSize, ShopAdSize, PartyAdSize, PartyMainSize,
        ShopImage
    }

    // 用户头像
    public static final int[][] UserImage = new int[][] {
            new int[] {90, 90} // 720
    };

    // 商家列表缩略图
    public static final int[][] ShopListSize = new int[][]{
            new int[]{160, 160} // 720
    };

    // 商家详细大图
    public static final int[][] ShopMainSize = new int[][]{
            new int[]{750, 360} // 720
    };

    // 商家图片
    public static final int[][] ShopImageSize = new int[][] {
            new int[] {340, 340}, // 720缩略图
            new int[] {Auto, Auto} // 原尺寸图
    };

    // 首页广告尺寸
    public static final int[][] ShopAdSize = new int[][]{
            new int[]{750, 288} // 720
    };

    // 活动广告尺寸
    public static final int[][] PartyAdSize = new int[][]{
            new int[]{750, 293} // 720
    };

    // 活动列表和标题尺寸
    public static final int[][] PartyMainSize = new int[][]{
            new int[]{750, 366} // 720
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
        if (ImageType.UserImage == imageType) {
            sizes = UserImage;
        } else if (ImageType.ShopListSize == imageType) {
            sizes = ShopListSize;
        } else if (ImageType.ShopMainSize == imageType) {
            sizes = ShopMainSize;
        } else if (ImageType.ShopAdSize == imageType) {
            sizes = ShopAdSize;
        } else if (ImageType.PartyAdSize == imageType) {
            sizes = PartyAdSize;
        } else if (ImageType.PartyMainSize == imageType) {
            sizes = PartyMainSize;
        } else if (ImageType.ShopImage == imageType) {
            sizes = ShopImageSize;
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
        private String path;

        // 构造方法
        public Image(String path, ImageType type) {
            if(null == path || "".equals(path)) {
                path720 = "";
                path = "";
            } else {
                if (ImageType.UserImage == type) {
                    this.path720 =
                            path + File.separator + "p_" + UserImage[0][0] + "x" + UserImage[0][1] + ".jpg";
                } else if (ImageType.ShopListSize == type) {
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
                } else if (ImageType.PartyMainSize == type) {
                    this.path720 =
                            path + File.separator + "p_" + PartyMainSize[0][0] + "x" + PartyMainSize[0][1] + ".jpg";
                } else if (ImageType.ShopImage == type) {
                    this.path720 =
                            path + File.separator + "p_" + ShopImageSize[0][0] + "x" + ShopImageSize[0][1] + ".jpg";
                    this.path =
                            path + File.separator + "p_" + ShopImageSize[1][0] + "x" + ShopImageSize[1][1] + ".jpg";
                }
            }
        }

        public String getPath720() {
            return path720;
        }
        public String getPath() {
            return path;
        }
    }

    private static ImageFactory ourInstance = new ImageFactory();

    public static ImageFactory getInstance() {
        return ourInstance;
    }

    private ImageFactory() {
    }
}
