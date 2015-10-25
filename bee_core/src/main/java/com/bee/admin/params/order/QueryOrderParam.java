package com.bee.admin.params.order;

/**
 * Created by suntongwei on 15/10/25.
 */
public class QueryOrderParam {

    // 所属商家ID
    private Long shopId;
    // 订单状态
    private Integer status;
    // 订单状态(查询状态)
    private Integer queryStatus;
    // 起始时间
    private Long startCreateTime;
    // 排序语句（A.createTime desc）
    private String sortSection;

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Long getStartCreateTime() {
        return startCreateTime;
    }
    public void setStartCreateTime(Long startCreateTime) {
        this.startCreateTime = startCreateTime;
    }
    public String getSortSection() {
        return sortSection;
    }
    public void setSortSection(String sortSection) {
        this.sortSection = sortSection;
    }
    public Integer getQueryStatus() {
        return queryStatus;
    }
    public void setQueryStatus(Integer queryStatus) {
        this.queryStatus = queryStatus;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
