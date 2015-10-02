package com.bee.commons;

/**
 * 订单状态机
 *
 * Created by suntongwei on 15/9/14.
 */
public final class OrderStatusMachine {

    /**
     * 用户是否能够取消订单
     * 只有订单状态 Consts.Order.Status.Create, Consts.Order.Status.Underway 才能取消
     *
     * @param status 当前订单状态
     * @return true 能取消订单, false 不能取消订单
     */
    public static boolean isCancelOrder(int status) {
        return (status == Consts.Order.Status.Create || status == Consts.Order.Status.Underway);
    }

    /**
     * 用户是否能修改订单
     * 只有订单状态 Consts.Order.Status.Create, Consts.Order.Status.Underway 才能修改
     *
     * @param status 当前订单状态
     * @return true 能修改订单, false 不能修改订单
     */
    public static boolean isEditOrder(int status) {
        return (status == Consts.Order.Status.Create || status == Consts.Order.Status.Underway);
    }

    /**
     * 商家是否可以拒绝订单
     * 只有订单状态 Consts.Order.Status.Create, Consts.Order.Status.Unknow才能拒绝
     * 拒绝订单和取消订单不同
     *
     * @param status 当前订单状态
     * @return
     */
    public static boolean isRejectOrder(int status) {
        return (status == Consts.Order.Status.Create || status == Consts.Order.Status.Unknow);
    }

    /**
     * 商家是否可以取消订单
     * 订单状态只有完成的订单不能取消
     *
     * @param status
     * @return
     */
    public static boolean isCancelBusiOrder(int status) {
        return (status != Consts.Order.Status.Finish);
    }

}
