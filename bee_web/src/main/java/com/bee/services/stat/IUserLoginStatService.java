package com.bee.services.stat;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/4/28.
 */
public interface IUserLoginStatService {

    /**
     * 增加用户登录统计
     *
     * @param uid
     * @throws DataRunException
     */
    public void addUserLoginStat(long uid) throws DataRunException;
}
