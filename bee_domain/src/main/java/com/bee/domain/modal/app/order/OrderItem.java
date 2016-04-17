package com.bee.domain.modal.app.order;

/**
 * Created by suntongwei on 15/11/25.
 */
public class OrderItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2467369067154140623L;

    // 订单编号
    private String no;
    // 商家地址
    private String addr;
    // 商家联系电话
    private String shopPhone;
    // 订单状态
    private Integer status;
    // 是否点评
    private Integer isComment;
    // 创建时间
    private Long createTime;
    // 是否返现 v1.1.0取消
    private Integer isBack;
    // v1.1.0 增加user
    private Long uid;
    // v1.1.1 增加商家GPS
    private Long lon;
    private Long lat;

    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public String getShopPhone() {
        return shopPhone;
    }
    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }
    public Integer getIsComment() {
        return isComment;
    }
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }
    public Integer getIsBack() {
        return isBack;
    }
    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
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
}
