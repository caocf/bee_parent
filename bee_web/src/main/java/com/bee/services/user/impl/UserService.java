package com.bee.services.user.impl;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.dao.user.UserDao;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.encrypt.Md5;
import com.qsd.framework.spring.PagingResult;
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
        user.setPassword(Md5.encodePassword(user.getPassword()));
        user.setType(Consts.User.Type.AppUser);
        user.setCreateTime(System.currentTimeMillis());
        user.setIdentity("U" + user.getCreateTime());
        user.setIntegral(0);
        user.setLevel(0);
        userDao.save(user);
    }

    @Override
    public PagingResult<User> queryUserListByParams(AdminUserListRequest req) {
        return userDao.queryUserListByParams(req);
    }
}
