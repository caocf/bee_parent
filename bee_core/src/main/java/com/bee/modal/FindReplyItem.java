package com.bee.modal;

/**
 * Created by suntongwei on 15/6/13.
 */
public class FindReplyItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -586893074017900125L;

    private Long frid;
    private Long uid;
    private String name;
    private String avatar;
    private Long createTime;
    private String content;

    public Long getFrid() {
        return frid;
    }
    public void setFrid(Long frid) {
        this.frid = frid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
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
}
