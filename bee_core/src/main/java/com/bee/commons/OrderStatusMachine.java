package com.bee.commons;

/**
 * 订单状态机
 *
 * Created by suntongwei on 15/9/14.
 */
public class OrderStatusMachine {

    /**
     * 是否能够取消订单
     * 只有订单状态 Consts.Order.Status.Create, Consts.Order.Status.Underway 才能取消
     *
     * @return true 能取消订单, false 不能取消订单
     */
    public static boolean isCancelOrder(int status) {
        return (status == Consts.Order.Status.Create || status == Consts.Order.Status.Underway);
    }

}
