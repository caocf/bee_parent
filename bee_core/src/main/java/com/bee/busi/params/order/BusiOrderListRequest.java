package com.bee.busi.params.order;

import com.qsd.framework.spring.AppRequest;

/**
 * Created by suntongwei on 15/9/23.
 */
public class BusiOrderListRequest extends AppRequest {

    // serialVersionUID
    private static final long serialVersionUID = -4966143397810458174L;

    /**
     * 商家ID
     */
    private Long shopId;
    /**
     * 查询状态
     * @see com.bee.commons.Consts.Order.Status
     */
    private Integer status;
    /**
     * 查询状态
     * @see com.bee.commons.Consts.Order.Status.Query
     */
    private Integer queryStatus;

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Integer getQueryStatus() {
        return queryStatus;
    }
    public void setQueryStatus(Integer queryStatus) {
        this.queryStatus = queryStatus;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
