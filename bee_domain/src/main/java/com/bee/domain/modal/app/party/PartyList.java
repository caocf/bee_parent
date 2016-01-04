package com.bee.domain.modal.app.party;

/**
 * Created by suntongwei on 15/12/31.
 */
public class PartyList implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -975335497995913308L;

    // 活动主键
    private Long pid;
    // 是否是官方活动
    private Integer isBee;
    // 活动类型
    private Integer type;
    // 活动状态
    private Integer status;
    // 活动显示在APP的时间范围
    private Long startTime;
    private Long stopTime;
    // 活动时间
    private String partyTime;
    // 活动标题
    private String title;
    // 活动内容
    private String content;
    // 是否报名
    private Integer isApply;

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public Integer getIsBee() {
        return isBee;
    }
    public void setIsBee(Integer isBee) {
        this.isBee = isBee;
    }
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    public Long getStopTime() {
        return stopTime;
    }
    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }
    public String getPartyTime() {
        return partyTime;
    }
    public void setPartyTime(String partyTime) {
        this.partyTime = partyTime;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getIsApply() {
        return isApply;
    }
    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }
}
