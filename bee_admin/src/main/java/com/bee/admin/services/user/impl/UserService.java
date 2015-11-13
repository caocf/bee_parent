package com.bee.admin.services.user.impl;

import com.bee.admin.services.user.IUserService;
import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.dao.user.UserDao;
import com.bee.pojo.user.User;
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
import com.qsd.framework.spring.PagingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 用户业务实现
 *
 * @since 2015-11-7
 * @version v1.0.0
 */
@Service
public class UserService implements IUserService {

    private static final Logger Log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    /**
     * 根据帐号返回用户
     *
     * @param account
     * @return User
     * @version v1.0.0
     */
    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    /**
     * 通过昵称获取用户
     * 后台发布商家评论，通过直接输入会员昵称来判断来创建用户
     * 如果获取到相同昵称，则使用该昵称，如果没有该昵称用户则创建
     * 不推荐使用，尽量在后续版本中删除
     *
     * @return
     */
    public User getUserByNick(String nick) {
        return userDao.getUserByNick(nick);
    }

    /**
     * 注册一个新用户
     * 通知环信，加入环信用户体系
     * A端创建测试用户所用
     *
     * @param user
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void createUser(User user) throws DataRunException {

        /**
         * 设置用户信息
         */
        user.setPassword(Md5.encodePassword(user.getPassword()));
        user.setType(Consts.User.Type.AppUser);
        user.setCreateTime(System.currentTimeMillis());
        user.setAlipay("");
        user.setExp(0);
        user.setIntegral(0);
        user.setLevel(0);
        user.setPath("");
        user.setUrl("");
        user.setCash(0d);
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
        ObjectNode res = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, datanode,
                HTTPMethod.METHOD_POST);
        Log.debug("[HX_Response]Register:" + res.toString());
    }

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req) {
        return userDao.queryUserListByParams(req);
    }
}
