package com.bee.modal;

import com.bee.commons.ImageFactory;

/**
 * Created by suntongwei on 15/4/30.
 */
public class ShopListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1131654802813555382L;

    private Long shopId;
    private ImageFactory.Image image;
    private ImageFactory.Image recommendImage;
    private String area;
    private String name;
    private String addr;
    private Integer friendNum;
    private Integer focusNum;
    private Double price;
    private Long lon;
    private Long lat;
    private String phone;
    private Integer type;
    private String linkName;
    private String nowInfo;

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
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public ImageFactory.Image getImage() {
        return image;
    }
    public void setImage(ImageFactory.Image image) {
        this.image = image;
    }
    public Long getLon() {
        return lon;
    }
    public void setLon(Long lon) {
        this.lon = lon;
    }
    public Long getLat() {
        return lat;
    }
    public void setLat(Long lat) {
        this.lat = lat;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getLinkName() {
        return linkName;
    }
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    public ImageFactory.Image getRecommendImage() {
        return recommendImage;
    }
    public void setRecommendImage(ImageFactory.Image recommendImage) {
        this.recommendImage = recommendImage;
    }
    public String getNowInfo() {
        return nowInfo;
    }
    public void setNowInfo(String nowInfo) {
        this.nowInfo = nowInfo;
    }
}
