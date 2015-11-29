package com.bee.domain.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/11/15.
 */
public class ShopImageListParam extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = -872834393188740429L;

    /**
     * 商家ID
     */
    private Long shopId;
    /**
     * 返回记录总数
     */
    private Integer top;
    /**
     * 排序
     */
    private String orderBy;

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Integer getTop() {
        return top;
    }
    public void setTop(Integer top) {
        this.top = top;
    }
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
