package com.bee.services.shop.admin.impl;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.commons.Consts;
import com.bee.dao.shop.ShopUserDao;
import com.bee.dao.user.UserDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopUser;
import com.bee.pojo.user.User;
import com.bee.services.shop.admin.IShopUserAdminService;
import com.bee.services.shop.impl.ShopUserService;
import com.easemob.server.comm.Constants;
import com.easemob.server.comm.HTTPMethod;
import com.easemob.server.comm.Roles;
import com.easemob.server.httpclient.utils.HTTPClientUtils;
import com.easemob.server.httpclient.vo.ClientSecretCredential;
import com.easemob.server.httpclient.vo.Credential;
import com.easemob.server.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.encrypt.Md5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class ShopUserAdminService extends ShopUserService implements IShopUserAdminService {

    private static final Logger Log = LoggerFactory.getLogger(ShopUserService.class);

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
     * 删除某个商家管理员
     *
     * @param shopUserId
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void deleteShopUser(long shopUserId) throws DataRunException {
        ShopUser shopUser = shopUserDao.getShopUserById(shopUserId);
        User user = shopUser.getUser();
        user.setType(Consts.User.Type.AppUser);
        userDao.update(user);
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
            userDao.update(user);
        } else {
            user = new User();
            user.setPhone(req.getAccount());
            user.setName(req.getName());
            user.setPassword(Md5.encodePassword(Consts.User.BusiInitPassword));
            user.setLevel(0);
            user.setIntegral(0);
            user.setCash(0d);
            user.setAlipay("");
            user.setCreateTime(System.currentTimeMillis());
            user.setDevice("");
            user.setExp(0);
            // v1.1.0取消
            // user.setPath("");
            // user.setUrl("");
            user.setType(Consts.User.Type.BusiUser);
            userDao.save(user);

            /**
             * 注册IM用户[单个]
             * 给指定AppKey创建一个新的用户
             */
            Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
                    Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);
            ObjectNode datanode = JsonNodeFactory.instance.objectNode();
            datanode.put("username", user.getIdentity());
            datanode.put("password", Constants.DEFAULT_PASSWORD);
            // 返回结果
            ObjectNode res = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, datanode, HTTPMethod.METHOD_POST);
            Log.debug("[HX_Response]Register:" + res.toString());
        }

        /**
         * 保存ShopUser
         */
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
