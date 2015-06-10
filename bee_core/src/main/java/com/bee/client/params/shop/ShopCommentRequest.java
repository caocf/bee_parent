package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/6/8.
 */
public class ShopCommentRequest extends PagingRequest {

    private static final long serialVersionUID = 6705792295090140919L;

    private Long shopId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
