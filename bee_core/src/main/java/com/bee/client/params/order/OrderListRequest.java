package com.bee.client.params.order;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/24.
 */
public class OrderListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 1030159951241693496L;

    /**
     * @see com.bee.commons.Consts.Order.Status.Query
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
