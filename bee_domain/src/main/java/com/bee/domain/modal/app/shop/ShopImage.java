package com.bee.domain.modal.app.shop;

/**
 * Created by suntongwei on 15/11/22.
 */
public class ShopImage implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6151977507173531821L;

    private Long shopImageId;
    private String url;
    private String remark;
    private Integer width;
    private Integer height;

    public Long getShopImageId() {
        return shopImageId;
    }
    public void setShopImageId(Long shopImageId) {
        this.shopImageId = shopImageId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
}
