package com.bee.services.user;

import com.bee.domain.params.user.UserParam;
import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IUserService {

    /**
     * <b>根据帐号获取用户</b>
     *
     * @param account 手机号
     * @return
     */
    User getUserByAccount(String account);

    /**
     * <b>根据参数查询用户信息</b>
     * 该接口主要提供用户信息的查询
     *
     * @param param
     * @return
     */
    User getUserByParam(UserParam param);

    /**
     * 根据ID获取用户
     *
     * @param uid
     * @return
     */
    User getUserById(long uid);

    /**
     * 用户更新
     *
     * @param user
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void editUser(User user) throws DataRunException;

    /**
     * 创建用户
     *
     * @param user
     * @throws DataRunException
     */
    void createUser(User user) throws DataRunException;
}
