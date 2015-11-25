package com.bee.domain.params.order;

import com.qsd.framework.domain.request.RequestPagingApp;

/**
 * Created by suntongwei on 15/11/25.
 */
public class OrderListParam extends RequestPagingApp {

    /**
     * com.bee.commons.Consts.Order.Status.Query
     */
    private Integer status;
    private Integer isCurOrder;
    private Long uid;
    private String device;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
    public Integer getIsCurOrder() {
        return isCurOrder;
    }
    public void setIsCurOrder(Integer isCurOrder) {
        this.isCurOrder = isCurOrder;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
