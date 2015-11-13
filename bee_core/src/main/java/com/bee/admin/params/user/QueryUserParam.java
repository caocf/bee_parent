package com.bee.admin.params.user;

/**
 * Created by suntongwei on 15/10/22.
 */
public class QueryUserParam {

    // 起始注册时间
    private Long startCreateTime;
    // 用户类型
    private Integer type;
    // 排序语句（A.createTime desc）
    private String sortSection;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
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
}
