package com.bee.dao.shop;


import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.pojo.shop.ShopTechee;
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
public class ShopTecheeDao extends JpaDaoSupport<ShopTechee, Long> {

    /**
     * 返回所属ShopGroup的所有ShopTechee
     *
     * @param gid
     * @return
     */
    public List<ShopTechee> getShopTecheeByGroupId(long gid) {
        return findByParams(SQL.Shop.Techee.GetShopTecheeByGroupId, gid);
    }

    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    public List<BusiShopTechee> getShopTecheeByShopId(long shopId) {
        return findConverByParams(SQL.Shop.Techee.GetShopTecheeByShopId,
                new QueryDataConver<BusiShopTechee>() {
                    @Override
                    public BusiShopTechee converData(Object[] row) {
                        BusiShopTechee item = new BusiShopTechee();
                        item.setStId(NumberUtil.parseLong(row[0], 0));
                        item.setNumber(StringUtil.parseString(row[1], ""));
                        item.setShopGroup(NumberUtil.parseLong(row[2], 0));
                        item.setShop(NumberUtil.parseLong(row[3], 0));
                        item.setGroupName(StringUtil.parseString(row[4], ""));
                        return item;
                    }
                }, shopId);
    }

    /**
     * 查询商家所有出勤技师
     *
     * @param sid 商家ID
     * @return
     */
    public List<ShopTecheeAttend> queryShopTecheeAttend(Long sid) {
        return findConverByParams(QueryShopTecheeAttend, new QueryDataConver<ShopTecheeAttend>() {
            @Override
            public ShopTecheeAttend converData(Object[] row) {
                ShopTecheeAttend item = new ShopTecheeAttend();
                item.setStId(NumberUtil.parseLong(row[0], 0));
                item.setNumber(StringUtil.parseString(row[1], ""));
                item.setGroupId(NumberUtil.parseLong(row[2], 0));
                item.setAttend(NumberUtil.parseInteger(row[3], Consts.False));
                item.setGroupName(StringUtil.parseString(row[4], ""));
                return item;
            }
        }, sid);
    }
    public static final String QueryShopTecheeAttend = "SELECT " +
            "A.STID, A.NUMBER, A.SHOPGROUP, A.ATTEND, B.GROUPNAME " +
            "FROM TB_SHOP_TECHEE A " +
            "LEFT OUTER JOIN " +
            "TB_SHOP_GROUP B " +
            "ON A.SHOPGROUP = B.SGID " +
            "WHERE A.SHOP = ?";
}
