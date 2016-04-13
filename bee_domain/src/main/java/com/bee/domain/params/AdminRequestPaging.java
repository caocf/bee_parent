package com.bee.domain.params;

import com.qsd.framework.domain.request.RequestPaging;

/**
 * Created by suntongwei on 16/4/14.
 */
public class AdminRequestPaging extends RequestPaging {

    private static final long serialVersionUID = -6892670453111767027L;

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
