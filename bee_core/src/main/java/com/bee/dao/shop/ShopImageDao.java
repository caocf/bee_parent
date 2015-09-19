package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.modal.ShopImageListItem;
import com.bee.pojo.shop.ShopImage;
import com.qsd.framework.commons.utils.NumberUtil;
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
                item.setUrl(StringUtil.parseString(objects[0], ""));
                item.setRemark(StringUtil.parseString(objects[1], ""));
                item.setWidth(NumberUtil.parseInteger(objects[2], 0));
                item.setHeight(NumberUtil.parseInteger(objects[3], 0));
                return item;
            }
        }, sid);
    }

    /**
     * 查询商家图片 To Find
     * 最多只显示9张
     *
     * @param sid
     * @return
     */
    public List<ShopImageListItem> queryFindShopImage(long sid) {
        return findConverByParams(SQL.Shop.Image.queryAppShopImage + " limit 9", new QueryDataConver<ShopImageListItem>() {
            @Override
            public ShopImageListItem converData(Object[] objects) {
                ShopImageListItem item = new ShopImageListItem();
                item.setUrl(StringUtil.parseString(objects[0], ""));
                item.setRemark(StringUtil.parseString(objects[1], ""));
                item.setWidth(NumberUtil.parseInteger(objects[2], 0));
                item.setHeight(NumberUtil.parseInteger(objects[3], 0));
                return item;
            }
        }, sid);
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
