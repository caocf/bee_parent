package com.bee.services.shop.admin;

import com.bee.pojo.shop.ShopImage;
import com.bee.services.shop.IShopImageService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopImageAdminService extends IShopImageService {

    /**
     * 根据商家ID查询商家图片集合
     *
     * @param sid
     * @return
     */
    List<ShopImage> queryShopImageByShopId(long sid);


    /**
     * 删除一张图片
     *
     * @param shopImageId
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void delShopImage(long shopImageId) throws DataRunException;


    /**
     * 获取一个商家图片
     *
     * @return
     */
    ShopImage getShopImageById(long id);

    /**
     * 更新商家图片
     *
     * @param req
     * @param file
     * @param shopImage
     * @throws DataRunException
     */
    void updateShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException;

    /**
     * 保存商家图片
     *
     * @param shopImage
     * @throws DataRunException
     */
    void addShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException;
}
