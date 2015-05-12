package com.bee.dao.market;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.commons.SQL;
import com.bee.modal.AdListItem;
import com.bee.pojo.market.Ad;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@Repository
public class AdDao extends JpaDaoSupport<Ad, Long> {

    /**
     * 查询广告列表
     *
     * @return
     */
    public List<Ad> getAdList() {
        return find(SQL.Market.Ad.getAdList);
    }

    /**
     * 根据类型查询
     *
     * @param type
     * @return
     */
    public List<AdListItem> getAppAdListByType(final int type) {
        return findConverByParams(SQL.Market.Ad.getAppAdList, new QueryDataConver<AdListItem>() {
            @Override
            public AdListItem converData(Object[] obj) {
                AdListItem item = new AdListItem();
                item.setAdid(NumberUtil.parseLong(obj[0], 0));
                item.setImage(new ImageFactory.Image(StringUtil.parseString(obj[1], ""), getImageType(type)));
                item.setShopId(NumberUtil.parseLong(obj[2], 0));
                item.setStopTime(NumberUtil.parseLong(obj[3], 0));
                return item;
            }
        }, System.currentTimeMillis(), type);
    }

    public List<AdListItem> getAddadListByUpdateTime(long updateTime) {
        return findConverByParams(SQL.Market.Ad.getAppAdListUpdateTime, new QueryDataConver<AdListItem>() {
            @Override
            public AdListItem converData(Object[] obj) {
                AdListItem item = new AdListItem();
                item.setAdid(NumberUtil.parseLong(obj[0], 0));
                int type = NumberUtil.parseInteger(obj[1], 0);
                item.setType(type);
                item.setImage(new ImageFactory.Image(StringUtil.parseString(obj[2], ""), getImageType(type)));
                item.setShopId(NumberUtil.parseLong(obj[3], 0));
                item.setStartTime(NumberUtil.parseLong(obj[4], 0));
                item.setStopTime(NumberUtil.parseLong(obj[5], 0));
                item.setSort(NumberUtil.parseInteger(obj[6], 0));
                return item;
            }
        }, updateTime);
    }

    private ImageFactory.ImageType getImageType(int type) {
        if(type == Consts.Ad.Type.Home) {
            return ImageFactory.ImageType.ShopAdSize;
        } else if(type == Consts.Ad.Type.Party) {
            return ImageFactory.ImageType.PartyAdSize;
        }
        return null;
    }
}
