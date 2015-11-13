package com.bee.admin.services.user;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

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

    /**
     * 通过昵称获取用户
     * 后台发布商家评论，通过直接输入会员昵称来判断来创建用户
     * 如果获取到相同昵称，则使用该昵称，如果没有该昵称用户则创建
     * 不推荐使用，尽量在后续版本中删除
     *
     * @param nick 用户昵称
     * @return
     */
    User getUserByNick(String nick);

    /**
     * 创建注册用户
     *
     * @param user
     */
    void createUser(User user) throws DataRunException;

    /**
     * 根据参数查询用户列表
     *
     * @param req
     * @return
     */
    PagingResult<User> queryUserListByParams(AdminUserListRequest req);
}
