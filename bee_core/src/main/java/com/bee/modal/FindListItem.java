package com.bee.modal;

import java.util.List;

/**
 * Created by suntongwei on 15/6/10.
 */
public class FindListItem implements java.io.Serializable {

    private Long findId;
    private Long userId;
    private Integer type;
    private String name;
    private String content;
    private Long createTime;
    private Long shopId;
    private String shopName;
    private Integer replyNum;

    // 商家图片
    private List<ShopImageListItem> shopImages;

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
    public Integer getReplyNum() {
        return replyNum;
    }
    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public List<ShopImageListItem> getShopImages() {
        return shopImages;
    }
    public void setShopImages(List<ShopImageListItem> shopImages) {
        this.shopImages = shopImages;
    }
}
