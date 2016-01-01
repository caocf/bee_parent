package com.bee.services.stat.app;

import com.bee.pojo.stat.UserLoginStat;
import com.bee.services.stat.IUserStatService;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/12/20.
 */
public interface IUserStatAppService extends IUserStatService {


    /**
     * 增加用户登录统计
     *
     * @param userLoginStat
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void addUserLoginStat(UserLoginStat userLoginStat) throws DataRunException;

}
