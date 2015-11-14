package com.bee.admin.params.stat;

/**
 * Created by suntongwei on 15/10/22.
 */
public class QueryUserLoginStatParam {

    /**
     * 起始时间
     */
    private Long startCreateTime;
    /**
     * 截至时间
     */
    private Long endCreateTime;
    /**
     * 排序
     */
    private String sortSection;
    /**
     * GroupBy字段
     */
    private String groupBy;

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
    public Long getEndCreateTime() {
        return endCreateTime;
    }
    public void setEndCreateTime(Long endCreateTime) {
        this.endCreateTime = endCreateTime;
    }
    public String getGroupBy() {
        return groupBy;
    }
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
}
