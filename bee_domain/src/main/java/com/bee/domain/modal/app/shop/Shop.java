package com.bee.domain.modal.app.shop;

/**
 * Created by suntongwei on 15/11/22.
 */
public class Shop implements java.io.Serializable {

    private Long shopId;
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
    private Integer isBack;
    private String serviceTime;

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
    public String getNowInfo() {
        return nowInfo;
    }
    public void setNowInfo(String nowInfo) {
        this.nowInfo = nowInfo;
    }
    public Integer getIsBack() {
        return isBack;
    }
    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }
    public String getServiceTime() {
        return serviceTime;
    }
    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }
}
