package com.bee.image;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by suntongwei on 15/9/7.
 */
public abstract class ShopImageParser extends ImageParser {

    // shopId参数标识
    public static final String SHOP_ID = "shopId";


    /**
     * 生成该图片文件目录名
     * 生成规则: /shop/shop_{shopId}
     *
     * @param shopId 店名ID
     * @return
     */
    public String genShopImageFilePath(Long shopId) {
        return File.separator + "static" + File.separator + "shop" + File.separator + "shop_" + shopId;
    }


}
