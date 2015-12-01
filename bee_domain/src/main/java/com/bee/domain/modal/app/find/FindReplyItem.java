package com.bee.domain.modal.app.find;

/**
 * Created by suntongwei on 15/12/1.
 */
public class FindReplyItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 2387929071196478178L;

    private Long frid;
    private Long uid;
    private String name;
    private String avatar;
    private Long createTime;
    private String content;
    private Integer level;

    public Long getFrid() {
        return frid;
    }
    public void setFrid(Long frid) {
        this.frid = frid;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
}
