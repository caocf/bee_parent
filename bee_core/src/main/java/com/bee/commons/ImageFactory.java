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

    public static final int MainPic[] = {
        120,60
    };

    /**
     * <p>保存图片</p>
     * <b>文件名规则</b> /file/{fileName}/{fileName}_{width}x{height}.jpg
     *
     * @param request
     * @param mFile
     * @return 返回图片的文件目录 /{fileName}
     */
    public synchronized String[] saveImage(HttpServletRequest request, MultipartFile mFile) {
        // 创建该图片基础名和目录
        String fileName = String.valueOf(System.currentTimeMillis());
        // 创建图片文件夹路径
        String p = File.separator + "static" + File.separator + fileName;
        // 本地磁盘路径
        String path = request.getSession().getServletContext().getRealPath(p);
        // 创建目录
        new File(path).mkdirs();
        // 创建图片路径
        String filePath = path + File.separator + "p_" + MainPic[0] + "x" + MainPic[1] + ".jpg";
        // 保存图片
        ImageUtils.zoomImage(MainPic[0], MainPic[1], mFile, new File(filePath));
        return new String[] {
                Consts.BaseUrl + p, path
        };
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

        // 图片路径
        private String path;

        // 构造方法
        public Image(String path) {
            this.path = path;
        }

        // 获取主图路径
        public String getMainPic() {
            return path + File.separator + "p_" + MainPic[0] + "x" + MainPic[1] + ".jpg";
        }
    }

    private static ImageFactory ourInstance = new ImageFactory();
    public static ImageFactory getInstance() {
        return ourInstance;
    }
    private ImageFactory() {
    }
}
