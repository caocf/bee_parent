package com.bee.services.stat.admin;

import com.bee.services.stat.IUserStatService;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IUserStatAdminService extends IUserStatService {

    /**
     * 统计过去number天用户登录数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    public Double[] statUserLogin(int number, long time);

    /**
     * 统计设备号数据
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    public Double[] statUserDeviceStat(int number, long time);

    /**
     * 统计过去number天用户注册数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    public Double[] statUserRegStat(int number, long time);

    /**
     * 统计用户登录详细
     *
     * @return startTime 开始时间
     */
    public Double[] statUserLoginDetail(long startTime, long endTime);
}
