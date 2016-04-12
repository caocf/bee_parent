package com.bee.dao.shop;


import com.bee.busi.model.shop.BusiShopTechee;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.domain.modal.app.shop.ShopTecheeAttend;
import com.bee.domain.modal.app.shop.ShopTecheeItem;
import com.bee.pojo.shop.ShopTechee;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.exception.DataRunException;
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
    public List<ShopTecheeItem> getShopTecheeByGroupId(long gid) {
        return findConverByParams(GetShopTecheeByGroupId, GetShopTecheeByGroupIdConver, gid);
    }
    private static final String GetShopTecheeByGroupId = "SELECT " +
            "A.STID, A.NUMBER, B.SGID, A.SHOP, B.GROUPNAME " +
            "FROM TB_SHOP_TECHEE A " +
            "LEFT OUTER JOIN " +
            "TB_SHOP_GROUP B " +
            "ON A.SHOPGROUP = B.SGID " +
            "WHERE B.SGID = ?";
    private static final QueryDataConver<ShopTecheeItem> GetShopTecheeByGroupIdConver =
            new QueryDataConver<ShopTecheeItem>() {
        @Override
        public ShopTecheeItem converData(Object[] row) {
            ShopTecheeItem item = new ShopTecheeItem();
            item.setStId(NumberUtil.parseLong(row[0], 0));
            item.setNumber(StringUtil.parseString(row[1], ""));
            item.setShopGroup(NumberUtil.parseLong(row[2], 0));
            item.setShop(NumberUtil.parseLong(row[3], 0));
            item.setGroupName(StringUtil.parseString(row[4], ""));
            return item;
        }
    };

    /**
     * 返回所属商家的所有ShopTechee
     *
     * @param shopId 商家ID
     * @return
     */
    public List<BusiShopTechee> getShopTecheeByShopId(long shopId) {
        return findConverByParams(SQL.Shop.Techee.GetShopTecheeByShopId,
                GetShopTecheeByShopIdConver, shopId);
    }
    private static final QueryDataConver<BusiShopTechee> GetShopTecheeByShopIdConver =
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
    };

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


    /**
     * 更新商家技师出勤表记录
     *
     * @param ids 更新记录ID集合
     */
    public void updateShopTecheeAttend(String ids) throws DataRunException {
        execute(UpdateShopTecheeAttend.replace("{inParams}", ids), Consts.True);
    }
    public static final String UpdateShopTecheeAttend = "UPDATE " +
            "TB_SHOP_TECHEE A " +
            "SET A.ATTEND = ? " +
            "WHERE " +
            "A.STID IN ({inParams})";

    /**
     * 根据商家ID,设置出勤表全为不出勤
     *
     * @param shopId
     */
    public void updateTecheeAttendToFalse(Long shopId) throws DataRunException {
        execute(UpdateShopTecheeAttendToFalse, Consts.False, shopId);
    }
    public static final String UpdateShopTecheeAttendToFalse = "UPDATE " +
            "TB_SHOP_TECHEE A " +
            "SET A.ATTEND = ? " +
            "WHERE " +
            "A.SHOP = ?";
}
