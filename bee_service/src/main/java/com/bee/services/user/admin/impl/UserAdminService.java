package com.bee.services.user.admin.impl;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.user.User;
import com.bee.services.user.admin.IUserAdminService;
import com.bee.services.user.impl.UserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.security.encrypt.Md5;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class UserAdminService extends UserService implements IUserAdminService {

    /**
     * 管理员帐号登录查找
     *
     * @param account 手机号
     * @return
     */
    @Override
    public User getUserByAccount(String account) {
        UserParam param = new UserParam();
        param.setPhone(account);
        param.setType(Consts.User.Type.AdminUser);
        return userDao.getUserLoginByParam(param);
    }

    /**
     * 注册一个新用户
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
        user.setType(Consts.User.Type.TestUser);
        user.setCreateTime(System.currentTimeMillis());
        user.setAlipay("");
        user.setExp(0);
        user.setIntegral(0);
        user.setLevel(0);
        user.setPath("");
        user.setUrl("");
        user.setCash(0d);
        userDao.save(user);

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
