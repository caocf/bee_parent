package com.bee.admin.services.user.impl;

import com.bee.dao.user.UserDao;
import com.bee.pojo.user.User;
import com.bee.admin.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现
 *
 * @since 2015-11-7
 * @version v1.0.0
 */
@Service
public class UserService implements IUserService {

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

}
