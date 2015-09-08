package com.bee.image;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片文件名生成器
 *
 * Created by suntongwei on 15/9/8.
 */
public interface ImageFileNameGenerate {

    /**
     * 返回文件名
     *
     * @return
     */
    String getFileName(HttpServletRequest request);
}
