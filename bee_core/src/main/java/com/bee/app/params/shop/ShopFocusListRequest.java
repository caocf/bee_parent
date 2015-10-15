package com.bee.app.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/10/13.
 */
public class ShopFocusListRequest extends PagingRequest {

    private static final long serialVersionUID = -9091082909797137941L;

    private Long uid;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public Integer getMaxRows() {
        return 10;
    }
}
