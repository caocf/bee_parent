package com.bee.dao.shop;

import com.bee.busi.model.shop.BusiShopGroup;
import com.bee.commons.SQL;
import com.bee.modal.ShopPriceItem;
import com.bee.pojo.shop.ShopGroup;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/10/8.
 */
@Repository
public class ShopGroupDao extends JpaDaoSupport<ShopGroup, Long> {

    /**
     * 返回商家对应的所有组
     *
     * @param sid
     * @return
     */
    public List<BusiShopGroup> getShopGroupByShopId(Long sid) {
        return findConverByParams(SQL.Shop.Group.GetShopGroupByShopId,
                new QueryDataConver<BusiShopGroup>() {
                    @Override
                    public BusiShopGroup converData(Object[] row) {
                        BusiShopGroup item = new BusiShopGroup();
                        item.setSgId(NumberUtil.parseLong(row[0], 0));
                        item.setGroupName(StringUtil.parseString(row[1], ""));
                        item.setShop(NumberUtil.parseLong(row[2], 0));
                        item.setPrice(NumberUtil.parseDouble(row[3], 0));
                        item.setRemark(StringUtil.parseString(row[4], ""));
                        return item;
                    }
                }, sid);
    }


    /**
     * 根据组查询所有价格
     *
     * @param sid
     * @return
     */
    public List<ShopPriceItem> queryShopPriceByShopId(Long sid) {
        return findConverByParams(SQL.Shop.Group.QueryShopPriceByShopId,
                new QueryDataConver<ShopPriceItem>() {
                    @Override
                    public ShopPriceItem converData(Object[] row) {
                        ShopPriceItem item = new ShopPriceItem();
                        item.setGroupName(StringUtil.parseString(row[0], ""));
                        item.setPrice(NumberUtil.parseDouble(row[1], 0d));
                        item.setRemark(StringUtil.parseString(row[2], ""));
                        return item;
                    }
                }, sid);
    }

}
