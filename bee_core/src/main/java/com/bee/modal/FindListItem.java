package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/6/10.
 */
public class FindListItem implements java.io.Serializable {

    private Long findId;
    private Long userId;
    private ImageFactory.Image avatar;
    private String name;
    private String content;
    private Long createTime;
    private Long shopId;
    private String shopName;
    private ImageFactory.Image shopImage;
    private Integer commentNum;

    public Long getFindId() {
        return findId;
    }

    public void setFindId(Long findId) {
        this.findId = findId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ImageFactory.Image getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageFactory.Image avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ImageFactory.Image getShopImage() {
        return shopImage;
    }

    public void setShopImage(ImageFactory.Image shopImage) {
        this.shopImage = shopImage;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
