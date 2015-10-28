package com.bee.admin.params.store;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/10/28.
 */
public class GoodsRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -6245689284929934883L;





    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
