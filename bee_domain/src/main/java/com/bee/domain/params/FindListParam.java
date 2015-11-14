package com.bee.domain.params;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/11/15.
 */
public class FindListParam extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -7578210537290041760L;

    /**
     * 最后刷新时间
     */
    private Long lastRefreshTime;

    public Long getLastRefreshTime() {
        return lastRefreshTime;
    }
    public void setLastRefreshTime(Long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

    /**
     * 是否需要分页
     *
     * @return
     */
    public boolean isPaging() {
        // 如果最后刷新时间不等于null，则不启用分页查询
        if (lastRefreshTime != null) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
