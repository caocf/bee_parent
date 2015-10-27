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
     * 排序
     */
    private String sortSection;

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
}
