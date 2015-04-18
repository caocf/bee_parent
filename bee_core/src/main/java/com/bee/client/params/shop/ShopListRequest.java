package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/16.
 */
public class ShopListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 1529406140351306476L;


    @Override
    public Integer getMaxRows() {
        return 30;
    }
}
