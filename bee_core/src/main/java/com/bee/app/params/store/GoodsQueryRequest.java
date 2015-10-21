package com.bee.app.params.store;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/10/21.
 */
public class GoodsQueryRequest extends PagingRequest {

    private static final long serialVersionUID = -5533594097685994346L;

    @Override
    public Integer getMaxRows() {
        return 20;
    }
}
