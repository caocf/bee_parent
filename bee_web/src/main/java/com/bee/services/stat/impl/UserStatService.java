package com.bee.services.stat.impl;

import com.bee.dao.stat.UserLoginStatDao;
import com.bee.dao.stat.UserRegStatDao;
import com.bee.pojo.stat.UserLoginStat;
import com.bee.pojo.stat.UserRegStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.IUserStatService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/4/28.
 */
@Service
public class UserStatService implements IUserStatService {

    @Autowired
    private UserLoginStatDao userLoginStatDao;
    @Autowired
    private UserRegStatDao userRegStatDao;

    @Override
    @Transactional
    public void addUserLoginStat(long uid) throws DataRunException {
        UserLoginStat stat = new UserLoginStat();
        stat.setUser(new User(uid));
        stat.setCreateTime(System.currentTimeMillis());
        stat.setDevice("");
        userLoginStatDao.save(stat);
    }

    @Override
    public List<UserRegStat> statUserRegStat() {
        return userRegStatDao.statDayRegStat();
    }
}
