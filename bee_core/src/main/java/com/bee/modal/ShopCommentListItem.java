package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/6/8.
 */
public class ShopCommentListItem implements java.io.Serializable {

    private static final long serialVersionUID = 9055067474898693248L;

    private Long scid;
    private Long shopId;
    private String name;
    private Long createTime;
    private String content;
    private Long uid;
    private ImageFactory.Image image;


    public Long getScid() {
        return scid;
    }

    public void setScid(Long scid) {
        this.scid = scid;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public ImageFactory.Image getImage() {
        return image;
    }

    public void setImage(ImageFactory.Image image) {
        this.image = image;
    }
}
