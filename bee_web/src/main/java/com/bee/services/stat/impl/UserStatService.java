package com.bee.services.stat.impl;

import com.bee.commons.Consts;
import com.bee.dao.stat.UserLoginStatDao;
import com.bee.pojo.stat.UserLoginStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.IUserStatService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/11.
 */
@Service
public class UserStatService implements IUserStatService {

    @Autowired
    private UserLoginStatDao userLoginStatDao;

    /**
     * 记录用户登录
     *
     * @param uid
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void addUserLoginStat(long uid, String device) throws DataRunException {
        UserLoginStat stat = new UserLoginStat();
        stat.setUser(new User(uid));
        stat.setCreateTime(System.currentTimeMillis());
        stat.setDevice(device);
        stat.setPhoneType(Consts.Android);
        stat.setAppVer(5);
        userLoginStatDao.save(stat);
    }
}
