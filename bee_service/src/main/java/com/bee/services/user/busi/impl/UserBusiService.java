package com.bee.services.user.busi.impl;

import com.bee.commons.Consts;
import com.bee.domain.params.user.UserParam;
import com.bee.pojo.user.User;
import com.bee.services.user.busi.IUserBusiService;
import com.bee.services.user.impl.UserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class UserBusiService extends UserService implements IUserBusiService {


    /**
     * 覆盖IUserService中的getUserByAccount()
     *
     * @param account 手机号
     * @return
     */
    @Override
    public User getUserByAccount(String account) {
        UserParam param = new UserParam();
        param.setPhone(account);
        param.setType(Consts.User.Type.BusiUser);
        return userDao.getUserLoginByParam(param);
    }

    /**
     *
     * @param user
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void createUser(User user) throws DataRunException {

    }
}
