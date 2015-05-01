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
                pageType = "OrderIng";
                break;
            case Consts.Order.Status.Query.Finish:
                pageType = "OrderEnd";
                break;
            default:
                pageType = "OrderIng";
        }
        return pageType;
    }

    @Override
    public Integer getMaxRows() {
        return 20;
    }
}
