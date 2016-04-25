package com.bee.domain.params.order;

import com.bee.commons.Consts;
import com.qsd.framework.domain.request.RequestPaging;

/**
 * Created by suntongwei on 16/4/26.
 */
public class AdminOrderParam extends RequestPaging {

    // serialVersionUID
    private static final long serialVersionUID = 5811952730862471470L;

    // @see com.bee.commons.Consts.Order.Status.Query
    private Integer status;
    // 实时监控，刷新时间s
    private Long queryTime;

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getQueryTime() {
        return queryTime;
    }
    public void setQueryTime(Long queryTime) {
        this.queryTime = queryTime;
    }

    public String getPageType() {
        String pageType = null;
        if (null == getStatus()) {
            return "navbar-inner-order-ing";
        }
        switch (getStatus()) {
            case Consts.Order.Status.Query.Ing:
                pageType = "navbar-inner-order-ing";
                break;
            case Consts.Order.Status.Query.Finish:
                pageType = "navbar-inner-order-end";
                break;
            default:
                pageType = "navbar-inner-order-cancel";
        }
        return pageType;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
