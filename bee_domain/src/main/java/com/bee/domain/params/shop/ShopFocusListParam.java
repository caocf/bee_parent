package com.bee.domain.params.shop;

import com.qsd.framework.domain.request.RequestPaging;

/**
 * Created by suntongwei on 15/11/17.
 */
public class ShopFocusListParam extends RequestPaging {

    // serialVersionUID
    private static final long serialVersionUID = 4613252486913923507L;

    // 用户ID
    private Long uid;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
