package com.bee.services.shop;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopAttendService {


    /**
     * 返回商家出勤最后更新时间
     *
     * @param shopId
     * @return
     */
    Long getShopAttendLastUpdateTime(long shopId);



}
