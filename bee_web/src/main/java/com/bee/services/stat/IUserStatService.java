package com.bee.services.stat;

import com.qsd.framework.hibernate.exception.DataRunException;

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
     * 统计过去number天用户登录数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    public Double[] statUserLogin(int number, long time);

    /**
     * 统计过去number天用户注册数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    public Double[] statUserRegStat(int number, long time);
}
