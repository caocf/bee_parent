package com.bee.services.shop.admin;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.pojo.shop.ShopUser;
import com.bee.services.shop.IShopUserService;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopUserAdminService extends IShopUserService {

    /**
     * 查询所有商家管理员
     *
     * @param shopId 商家ID
     * @return
     */
    List<ShopUser> queryShopUserList(long shopId);

    /**
     * 删除商家管理员
     *
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void deleteShopUser(long shopUserId) throws DataRunException;

    /**
     * 创建一个商家管理员
     *
     * @throws DataRunException
     */
    void saveShopUser(AdminShopUserSaveRequest req) throws DataRunException;
}
