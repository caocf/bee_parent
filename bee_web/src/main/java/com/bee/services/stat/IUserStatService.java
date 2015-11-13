package com.bee.services.stat;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/11.
 */
public interface IUserStatService {

    /**
     * 增加用户登录统计
     *
     * @param uid
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    public void addUserLoginStat(long uid, String device) throws DataRunException;
}
