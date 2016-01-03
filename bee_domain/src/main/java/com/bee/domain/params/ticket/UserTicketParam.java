package com.bee.domain.params.ticket;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 16/1/3.
 */
public class UserTicketParam extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = -6913941932100939008L;

    // 用户ID
    private Long userId;
    // 优惠券状态
    private Integer status;
    // 商家ID
    private Long shopId;
    // 所属订单ID
    private Long orderId;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
