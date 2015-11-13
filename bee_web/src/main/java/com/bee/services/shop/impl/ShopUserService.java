package com.bee.services.shop.impl;

import com.bee.admin.params.shop.AdminShopUserSaveRequest;
import com.bee.busi.model.user.BusiShopUser;
import com.bee.commons.Consts;
import com.bee.core.UserCacheFactory;
import com.bee.dao.shop.ShopUserDao;
import com.bee.dao.user.UserDao;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopUser;
import com.bee.pojo.user.User;
import com.bee.services.shop.IShopUserService;
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
 * Created by suntongwei on 15/9/13.
 */
@Service
public class ShopUserService implements IShopUserService {

    @Autowired
    private ShopUserDao shopUserDao;

    /**
     * 返回登录商户信息
     *
     * @param uid 用户ID
     * @return
     */
    public BusiShopUser getShopUserByLogin(long uid) {
        return shopUserDao.getShopUserByLogin(uid);
    }

}

