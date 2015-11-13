package com.bee.client.params.order;

import com.bee.commons.Consts;
import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/4/24.
 */
public class AdminOrderListRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -3658219948438120869L;

    /**
     * @see com.bee.commons.Consts.Order.Status.Query
     */
    private Integer status;
    /**
     * 实时监控，刷新时间s
     */
    private Long queryTime;
    /**
     * 是否自动更新
     */
    private Boolean isAuto;

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPageType() {
        String pageType = null;
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

    public Long getQueryTime() {
        return queryTime;
    }
    public void setQueryTime(Long queryTime) {
        this.queryTime = queryTime;
    }

    public Boolean getIsAuto() {
        return isAuto;
    }
    public void setIsAuto(Boolean isAuto) {
        this.isAuto = isAuto;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
