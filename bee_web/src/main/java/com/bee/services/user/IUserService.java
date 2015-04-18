package com.bee.services.user;

import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/4/15.
 */
public interface IUserService {

    /**
     * 获取用户
     *
     * @param account
     * @return
     */
    public User getUserByAccount(String account);

    /**
     * 创建注册用户
     *
     * @param user
     */
    public void createUser(User user) throws DataRunException;
}
