package com.bee.services.shop.impl;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.busi.model.user.BusiShopUser;
import com.bee.commons.Consts;
import com.bee.dao.shop.ShopUserDao;
import com.bee.dao.user.UserDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopUser;
import com.bee.pojo.user.User;
import com.bee.services.shop.IShopUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.encrypt.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/9/13.
 */
@Service
public class ShopUserService implements IShopUserService {

    @Autowired
    private ShopUserDao shopUserDao;
    @Autowired
    private UserDao userDao;


    /**
     * 查询所有商家用户
     *
     * @param shopId 商家ID
     * @return
     */
    @Override
    public List<ShopUser> queryShopUserList(long shopId) {
        return shopUserDao.queryShopUserList(shopId);
    }

    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    public BusiShopUser getShopUserByLogin(long uid) {
        return shopUserDao.getShopUserByLogin(uid);
    }


    /**
     * 删除某个商家管理员
     *
     * @param shopUserId
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShopUser(long shopUserId) throws DataRunException {
        shopUserDao.deleteById(shopUserId);
    }

    /**
     * 创建一个商家管理员
     *
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void saveShopUser(AdminShopUserSaveRequest req) throws DataRunException {

        // 判断该用户是否存在
        User user = userDao.getUserByAccount(req.getAccount());
        if (user != null) {
            user.setType(Consts.User.Type.BusiUser);
        } else {
            user = new User();
            user.setPhone(req.getAccount());
            user.setName(req.getName());
            user.setPassword(Md5.encodePassword("000000"));
            user.setLevel(0);
            user.setIntegral(0);
            user.setCash(0d);
            user.setAlipay("");
            user.setCreateTime(System.currentTimeMillis());
            user.setDevice("");
            user.setExp(0);
            user.setPath("");
            user.setUrl("");
            user.setType(Consts.User.Type.BusiUser);
        }
        userDao.save(user);

        // 保存ShopUser
        ShopUser shopUser = new ShopUser();
        shopUser.setName(req.getName());
        shopUser.setPhone(req.getAccount());
        shopUser.setShop(new Shop(req.getShopId()));
        shopUser.setUser(new User(user.getUid()));
        shopUser.setIntroduce("");
        shopUser.setCreateTime(System.currentTimeMillis());

        shopUserDao.save(shopUser);

    }
}

