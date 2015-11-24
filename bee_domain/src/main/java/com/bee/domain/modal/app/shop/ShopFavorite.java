package com.bee.domain.modal.app.shop;

/**
 * <b>收藏商家实体</b>
 *
 * @since C端v1.0.5
 */
public class ShopFavorite implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -7683468098995197900L;

    // 商家ID
    private Long shopId;
    // 商家名称
    private String shopName;
    // 收藏时间
    private Long createTime;
    // 商家店状态
    private Integer shopStatus;

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Integer getShopStatus() {
        return shopStatus;
    }
    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }
}
