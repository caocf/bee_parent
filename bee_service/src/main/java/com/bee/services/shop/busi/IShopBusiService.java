package com.bee.services.shop.busi;

import com.bee.pojo.shop.Shop;
import com.bee.services.shop.IShopService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopBusiService extends IShopService {

    /**
     * 关闭商家(B端)
     *
     * @param shop
     */
    void closeShop(Shop shop) throws DataRunException;

    /**
     * 修改商家列表图片
     *
     * @param shopId
     * @param req
     */
    void saveShopListImage(long shopId, MultipartHttpServletRequest req);


    /**
     * 保存商家门店图片
     *
     * @param shopId
     * @param req
     */
    void saveShopImage(long shopId, MultipartHttpServletRequest req);

    /**
     * 保存商家宣传视频
     *
     * @param shopId
     * @param req
     */
    void saveShopVideo(long shopId, MultipartFile file, MultipartHttpServletRequest req) throws DataRunException;
}
