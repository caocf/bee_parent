package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/6/12.
 */
public class ShopReplyListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6417678112928991810L;

    private Long srid;
    private String name;
    private ImageFactory.Image avatar;
    private Long createTime;
    private String content;

    public Long getSrid() {
        return srid;
    }

    public void setSrid(Long srid) {
        this.srid = srid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageFactory.Image getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageFactory.Image avatar) {
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
}
