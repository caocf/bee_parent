package com.bee.domain.modal.app.shop;

/**
 * <b>【C端】商家实体</b>
 *
 * v1.0.5
 * 添加字段
 * isFreeParking, isFood, isInvoice
 * 删除字段
 * phone, linkName, nowInfo, isBack
 *
 * @since v1.0.4
 */
public class ShopItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8742191834751433381L;

    private Long shopId;
    private String area;
    private String name;
    private String addr;
    private Integer friendNum;
    private Integer focusNum;
    private Double price;
    private Long lon;
    private Long lat;
    private Integer type;
    @Deprecated
    private String phone;
    @Deprecated
    private String linkName;
    @Deprecated
    private String nowInfo;
    @Deprecated
    private Integer isBack;
    private String serviceTime;

    // v1.2开始增加
    // 以下为商家配置信息ShopConfig内容
    private Integer hasVideo;
    private Integer videoVer;

    /**
     * v1.0.5新增
     */
    // 是否提供免费停车
    private Integer isFreeParking;
    // 是否提供餐饮
    private Integer isFood;
    // 是否提供发票
    private Integer isInvoice;
    // 是否提供刷卡
    private Integer isPosCard;

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
    @Deprecated
    public String getPhone() {
        return phone;
    }
    @Deprecated
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Deprecated
    public String getLinkName() {
        return linkName;
    }
    @Deprecated
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    @Deprecated
    public String getNowInfo() {
        return nowInfo;
    }
    @Deprecated
    public void setNowInfo(String nowInfo) {
        this.nowInfo = nowInfo;
    }
    @Deprecated
    public Integer getIsBack() {
        return isBack;
    }
    @Deprecated
    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }
    public String getServiceTime() {
        return serviceTime;
    }
    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }
    public Integer getIsFreeParking() {
        return isFreeParking;
    }
    public void setIsFreeParking(Integer isFreeParking) {
        this.isFreeParking = isFreeParking;
    }
    public Integer getIsFood() {
        return isFood;
    }
    public void setIsFood(Integer isFood) {
        this.isFood = isFood;
    }
    public Integer getIsInvoice() {
        return isInvoice;
    }
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }
    public Integer getIsPosCard() {
        return isPosCard;
    }
    public void setIsPosCard(Integer isPosCard) {
        this.isPosCard = isPosCard;
    }
    public Integer getHasVideo() {
        return hasVideo;
    }
    public void setHasVideo(Integer hasVideo) {
        this.hasVideo = hasVideo;
    }
    public Integer getVideoVer() {
        return videoVer;
    }
    public void setVideoVer(Integer videoVer) {
        this.videoVer = videoVer;
    }
}
