package com.bee.dao.shop;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.ShopImageListItem;
import com.bee.pojo.shop.ShopImage;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/23.
 */
@Repository
public class ShopImageDao extends JpaDaoSupport<ShopImage, Long> {

    /**
     *
     * @param sid
     * @return
     */
    public List<ShopImageListItem> queryAppShopImage(long sid) {
        return findConverByParams(SQL.Shop.Image.queryAppShopImage, new QueryDataConver<ShopImageListItem>() {
            @Override
            public ShopImageListItem converData(Object[] objects) {
                ShopImageListItem item = new ShopImageListItem();
                item.setImage(new ImageFactory.Image(StringUtil.parseString(objects[0], null), ImageFactory.ImageType.ShopImage));
                item.setRemark(StringUtil.parseString(objects[1], ""));
                return item;
            }
        }, sid, Consts.Shop.ImageType.Photo);
    }

    /**
     *
     *
     * @param sid
     * @return
     */
    public List<ShopImage> queryShopImageByShopId(long sid) {
        return findByParams(SQL.Shop.Image.queryShopImageByShopId, sid);
    }

    /**
     *
     * @param id
     * @return
     */
    public ShopImage getShopImageById(long id) {
        return findFirstByParams(SQL.Shop.Image.getShopImageById, id);
    }

}
