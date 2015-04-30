package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/30.
 */
public class ShopListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -7814828946282931137L;

    private Long uid;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public Integer getMaxRows() {
        return 20;
    }
}
