package com.bee.modal;

/**
 * Created by suntongwei on 15/6/12.
 */
public class ShopReplyListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6417678112928991810L;

    private Long srid;
    private Long uid;
    private String name;
    private Long createTime;
    private String content;

    public Long getSrid() {
        return srid;
    }
    public void setSrid(Long srid) {
        this.srid = srid;
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
