package com.bee.domain.params.find;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 15/11/29.
 */
public class FindSaveParam extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = -4179969292027077911L;

    // 发现内容
    private String content;
    // 图片类型
    private Integer imageType;
    // 图片ID集合,仅对ShopImage有效
    private String imageIds;
    // 所属商家
    private Long shopId;
    // 创建人
    private Long uid;

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getImageType() {
        return imageType;
    }
    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }
    public String getImageIds() {
        return imageIds;
    }
    public void setImageIds(String imageIds) {
        this.imageIds = imageIds;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
}
