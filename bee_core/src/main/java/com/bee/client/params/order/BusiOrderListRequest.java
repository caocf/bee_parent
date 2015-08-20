package com.bee.client.params.order;

import com.qsd.framework.spring.AppRequest;

/**
 * Created by suntongwei on 15/8/19.
 */
public class BusiOrderListRequest extends AppRequest {

    // serialVersionUID
    private static final long serialVersionUID = 1116363777133423606L;

    private Long shopId;
    private Integer status;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
