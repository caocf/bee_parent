package com.bee.services.shop;

import com.bee.modal.ShopImageListItem;
import com.bee.pojo.shop.ShopImage;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
public interface IShopImageService {

    /**
     * 获取app商家图片集合
     *
     * @param sid
     * @return
     */
    public List<ShopImageListItem> queryAppShopImage(long sid);

    /**
     * 根据商家ID查询商家图片集合
     *
     * @param sid
     * @return
     */
    public List<ShopImage> queryShopImageByShopId(long sid);

    /**
     * 保存商家图片
     *
     * @param shopImage
     * @throws DataRunException
     */
    public void addShopImage(HttpServletRequest req, MultipartFile file, ShopImage shopImage) throws DataRunException;

    /**
     * 删除一张图片
     *
     * @param shopImageId
     * @throws DataRunException
     */
    public void delShopImage(long shopImageId) throws DataRunException;


}
