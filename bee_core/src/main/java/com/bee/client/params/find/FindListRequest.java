package com.bee.client.params.find;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/6/10.
 */
public class FindListRequest extends PagingRequest {

    private static final long serialVersionUID = -7677550234475572238L;

    /**
     * 最后刷新时间
     */
    private Long refreshTime;

    public Long getRefreshTime() {
        return refreshTime;
    }
    public void setRefreshTime(Long refreshTime) {
        this.refreshTime = refreshTime;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
