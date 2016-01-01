package com.bee.commons;

/**
 * 积分计算器
 *
 * Created by suntongwei on 15/10/2.
 */
public final class IntegralMachine {

    /**
     * 完成订单获取额外积分（活动积分）
     */
    public static final int OrderFinishExtra = 0;

    /**
     * 完成订单获得积分
     */
    public static final int OrderFinish = 1000 + OrderFinishExtra;

    /**
     * 完成订单评论积分
     */
    public static final int OrderComment = 200;


}
