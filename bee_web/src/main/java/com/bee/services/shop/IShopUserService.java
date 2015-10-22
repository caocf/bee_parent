package com.bee.services.shop;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.busi.model.user.BusiShopUser;
import com.bee.pojo.shop.ShopUser;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

import java.util.List;

/**
 * Created by suntongwei on 15/9/13.
 */
public interface IShopUserService {


    /**
     * 查询所有商家管理员
     *
     * @param shopId 商家ID
     * @return
     */
    public List<ShopUser> queryShopUserList(long shopId);


    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    public BusiShopUser getShopUserByLogin(long uid);


    /**
     * 删除商家管理员
     *
     * @throws DataRunException
     */
    public void deleteShopUser(long shopUserId) throws DataRunException;

    /**
     * 创建一个商家管理员
     *
     * @throws DataRunException
     */
    public void saveShopUser(AdminShopUserSaveRequest req) throws DataRunException;
}
