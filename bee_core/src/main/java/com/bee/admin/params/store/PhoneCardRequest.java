package com.bee.admin.params.store;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/10/28.
 */
public class PhoneCardRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 3664490524925758307L;

    private Long goodsId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
