package com.bee.services.user.app.impl;

import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.easemob.EasemobFactory;
import com.bee.pojo.user.User;
import com.bee.services.user.app.IUserAppService;
import com.bee.services.user.impl.UserService;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 16/1/3.
 */
@Service
public class UserAppService extends UserService implements IUserAppService {

    /**
     * 获取用户
     *
     * @param account 手机号
     * @return
     */
    @Override
    public User getUserByAccount(String account) {
        UserParam param = new UserParam();
        param.setPhone(account);
        param.setType(Consts.User.Type.AppUser);
        return userDao.getUserLoginByParam(param);
    }

    /**
     * 注册用户
     *
     * @param user
     * @throws DataRunException
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
        user.setCash(0d);
        userDao.save(user);

        /**
         * 如果不是DEBUG模式添加环信
         */
        if (!Consts.isDebug) {
            EasemobFactory.getInstance().createUser(user.getIdentity());
        }
    }
}
