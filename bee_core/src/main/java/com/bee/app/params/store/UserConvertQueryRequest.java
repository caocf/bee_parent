package com.bee.app.params.store;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/10/21.
 */
public class UserConvertQueryRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 8234182988269296199L;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Integer getMaxRows() {
        return 20;
    }
}
