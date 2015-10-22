package com.bee.dao.shop;

import com.bee.busi.model.user.BusiShopUser;
import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopUser;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/9/13.
 */
@Repository
public class ShopUserDao extends JpaDaoSupport<ShopUser, Long> {


    /**
     * 查询所有商家用户
     *
     * @param shopId 商家ID
     * @return
     */
    public List<ShopUser> queryShopUserList(long shopId) {
        return findByParams(SQL.Shop.Admin.queryShopAdminList, shopId);
    }

    /**
     *
     *
     * @param shopUserId
     * @return
     */
    public ShopUser getShopUserById(long shopUserId) {
        return findFirstByParams(SQL.Shop.User.GetShopUserById, shopUserId);
    }

    /**
     * 查询商家管理员
     * 用于创建订单时，传入该订单服务经理，目前主要采用单经理模式
     *
     * @param shopId 所属商家ID
     * @return
     */
    public ShopUser getShopUserByShopId(long shopId) {
        return findFirstByParams(SQL.Shop.User.getShopUserByShopId, shopId);
    }

    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    public BusiShopUser getShopUserByLogin(long uid) {
        return findFirstConverByParams(SQL.Shop.User.GetShopUserByLogin, new QueryDataConver<BusiShopUser>() {
            @Override
            public BusiShopUser converData(Object[] objs) {
                BusiShopUser item = new BusiShopUser();
                item.setShopId(NumberUtil.parseLong(objs[0], 0));
                item.setShopName(StringUtil.parseString(objs[1], ""));
                item.setShopStatus(NumberUtil.parseInteger(objs[2], 0));
                item.setUserId(NumberUtil.parseLong(objs[3], 0));
                item.setUserNick(StringUtil.parseString(objs[4], ""));
                item.setPhone(StringUtil.parseString(objs[5], ""));
                return item;
            }
        }, uid);
    }
}
