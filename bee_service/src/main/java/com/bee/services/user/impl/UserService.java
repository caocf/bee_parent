package com.bee.services.user.impl;

import com.bee.commons.Consts;
import com.bee.dao.user.UserDao;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class UserService implements IUserService {

    @Autowired
    protected UserDao userDao;

    /**
     * 用户更新
     *
     * @param user
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void editUser(User user) throws DataRunException {
        userDao.update(user);
    }

    /**
     * @see com.bee.services.user.IUserService#getUserByParam
     * @param param
     * @return
     */
    @Override
    public User getUserByParam(UserParam param) {
        return userDao.getUserByParam(param);
    }

    /**
     * 根据ID获取用户
     *
     * @param uid
     * @return
     */
    @Override
    public User getUserById(long uid) {
        return userDao.findById(uid);
    }
}
