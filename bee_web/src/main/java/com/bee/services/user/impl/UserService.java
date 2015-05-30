package com.bee.services.user.impl;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 15/4/15.
 */
@Service
public class UserService implements IUserService {

    // LOG
    private final Logger Log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    public User getUserByIdentity(String identity) {
        return userDao.findById(0l + Integer.valueOf(identity) - Consts.User.IdentityBaseNum);
    }

    @Override
    @Transactional
    public void createUser(User user) throws DataRunException {

        /**
         * 设置用户信息
         */
        user.setPassword(Md5.encodePassword(user.getPassword()));
        user.setType(Consts.User.Type.AppUser);
        user.setCreateTime(System.currentTimeMillis());
        user.setIntegral(0);
        user.setLevel(0);
        user.setPath("");
        user.setUrl("");
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

    @Override
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req) {
        return userDao.queryUserListByParams(req);
    }

    @Override
    @Transactional
    public void saveAvatar(Long uid, MultipartFile file, HttpServletRequest req) throws RuntimeException {
        User user = userDao.findById(uid);
        if (!file.isEmpty()) {
            String[] paths = ImageFactory.getInstance().saveImage(ImageFactory.ImageType.UserImage, req, file);
            user.setUrl(paths[0]);
            user.setPath(paths[1]);
            userDao.update(user);
        }
    }

    @Override
    @Transactional
    public void saveNickName(long uid, String nickName) throws DataRunException {
        User user = userDao.findById(uid);
        user.setName(nickName);
        userDao.update(user);
    }
}
