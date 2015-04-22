package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/16.
 */
public class ShopListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 1529406140351306476L;

    private Integer type;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public Integer getMaxRows() {
        return 30;
    }
}
