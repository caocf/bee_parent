package com.bee.services.user.impl;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.dao.user.UserDao;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
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
import com.qsd.framework.security.encrypt.Base64;
import com.qsd.framework.security.encrypt.Md5;
import com.qsd.framework.spring.PagingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/4/15.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    @Transactional
    public void createUser(User user) throws DataRunException {

        /**
         * 注册IM用户[单个]
         * 给指定AppKey创建一个新的用户
         */
        Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
                Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username", user.getPhone());
        datanode.put("password", Constants.DEFAULT_PASSWORD);
        // 返回结果
        HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, datanode,
                HTTPMethod.METHOD_POST);

        /**
         * 设置用户信息
         */
        user.setPassword(Md5.encodePassword(user.getPassword()));
        user.setType(Consts.User.Type.AppUser);
        user.setCreateTime(System.currentTimeMillis());
        user.setIdentity("u" + user.getCreateTime());
        user.setIntegral(0);
        user.setLevel(0);
        user.setPath("");
        user.setUrl("");
        userDao.save(user);
    }

    @Override
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req) {
        return userDao.queryUserListByParams(req);
    }
}
