package com.bee.services.stat.impl;

import com.bee.dao.stat.UserLoginStatDao;
import com.bee.pojo.stat.UserLoginStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.IUserLoginStatService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/4/28.
 */
@Service
public class UserLoginStatService implements IUserLoginStatService {

    @Autowired
    private UserLoginStatDao userLoginStatDao;

    @Override
    public void addUserLoginStat(long uid) throws DataRunException {
        UserLoginStat stat = new UserLoginStat();
        stat.setUser(new User(uid));
        stat.setCreateTime(System.currentTimeMillis());
        userLoginStatDao.save(stat);
    }
}
