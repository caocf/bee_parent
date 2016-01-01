package com.bee.services.stat.app.impl;

import com.bee.pojo.stat.UserLoginStat;
import com.bee.services.stat.app.IUserStatAppService;
import com.bee.services.stat.impl.UserStatService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/12/20.
 */
@Service
public class UserStatAppService extends UserStatService implements IUserStatAppService {

    /**
     *
     * @param userLoginStat
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void addUserLoginStat(UserLoginStat userLoginStat) throws DataRunException {
        userLoginStat.setCreateTime(System.currentTimeMillis());
        userLoginStatDao.save(userLoginStat);
    }
}
