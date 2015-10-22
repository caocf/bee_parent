package com.bee.admin.params.user;

/**
 * Created by suntongwei on 15/10/22.
 */
public class QueryUserParam {

    // 起始注册时间
    private Long startCreateTime;
    // 排序语句（A.createTime desc）
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
