package com.bee.domain.modal.app.shop;

/**
 * 商家列表实体
 *
 * Created by suntongwei on 15/11/25.
 */
public class ShopListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1880118987440839974L;

    // 商家ID
    private Long shopId;
    // 所属地区
    private String area;
    // 商家名称
    private String name;
    // 商家模糊地址
    private String addr;
    // 好友关注数
    private Integer friendNum;
    // 商家粉丝数
    private Integer focusNum;
    // 价格
    private Double price;
    // 商家类型
    private Integer type;

    /**
     * 老接口弃用字段
     */
    @Deprecated
    private Integer isBack;
    /**
     * v1.1.1增加,是否直营店
     */
    private Integer isBeeShop;
    /**
     * v1.2.0增加,是否有推广视频
     */
    private Integer hasVideo;


    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public Integer getFriendNum() {
        return friendNum;
    }
    public void setFriendNum(Integer friendNum) {
        this.friendNum = friendNum;
    }
    public Integer getFocusNum() {
        return focusNum;
    }
    public void setFocusNum(Integer focusNum) {
        this.focusNum = focusNum;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Deprecated
    public Integer getIsBack() {
        return isBack;
    }
    @Deprecated
    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }
    public Integer getIsBeeShop() {
        return isBeeShop;
    }
    public void setIsBeeShop(Integer isBeeShop) {
        this.isBeeShop = isBeeShop;
    }
    public Integer getHasVideo() {
        return hasVideo;
    }
    public void setHasVideo(Integer hasVideo) {
        this.hasVideo = hasVideo;
    }
}
