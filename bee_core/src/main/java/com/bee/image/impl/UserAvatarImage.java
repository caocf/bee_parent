package com.bee.image.impl;

import com.bee.image.ImageParser;
import com.qsd.framework.commons.utils.ImageUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 用户头像
 *
 * Created by suntongwei on 15/9/17.
 */
public class UserAvatarImage extends ImageParser {

    public static final String USER_ID = "UserId";

    @Override
    public String[] generate(HttpServletRequest request, MultipartFile file) {

        // 获取用户ID
        Long userId = Long.valueOf(request.getAttribute(USER_ID).toString());

        // 创建网络路径
        String netPath = genUserAvatarImageFilePath(userId);
        // 创建本地路径
        String diskPath = getDiskPath(request, netPath);
        mkdirs(diskPath);

        // 文件名
        String fileName = getFileName(request);

        // 生成图片
        File f = new File(diskPath + File.separator + fileName);
        if (f.exists()) {
            f.delete();
        }

        // 720图片
        ImageUtils.zoomImage(120, 120, file, f);

        return new String[] {
                netPath + File.separator + fileName,
                diskPath + File.separator + fileName
        };
    }

    @Override
    public void parser() {

    }

    /**
     * 生成用户头像图片路径
     * /static/user/user_{userId}
     *
     * @param userId
     * @return
     */
    public String genUserAvatarImageFilePath(long userId) {
        return File.separator + "static" + File.separator + "user" + File.separator + "user_" + userId;
    }

    @Override
    public String getFileName(HttpServletRequest request) {
        return "avatar_720" + ImageTypeEnum.JPG.toString();
    }
}
