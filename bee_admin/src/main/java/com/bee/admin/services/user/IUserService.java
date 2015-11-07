package com.bee.admin.services.user;

import com.bee.pojo.user.User;

/**
 * 用户业务接口
 *
 * @since 2015-11-7
 * @version v1.0.0
 */
public interface IUserService {

    /**
     * 根据帐号返回用户
     *
     * @param account
     * @return User
     * @version v1.0.0
     */
    User getUserByAccount(String account);
}
