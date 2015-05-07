package com.bee.services.stat;

import com.bee.pojo.stat.UserRegStat;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/4/28.
 */
public interface IUserStatService {

    /**
     * 增加用户登录统计
     *
     * @param uid
     * @throws DataRunException
     */
    public void addUserLoginStat(long uid) throws DataRunException;

    /**
     * 统计过去30天用户注册数量
     *
     * @return
     */
    public List<UserRegStat> statUserRegStat();
}
