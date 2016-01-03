package com.bee.domain.modal.app.ticket;


/**
 * Created by suntongwei on 16/1/3.
 */
public class TicketList implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1416038683040804670L;

    // 主键
    private Long userTicketId;
    // 优惠券
    private Long ticketId;
    // 类型
    private Integer type;
    // 使用状态
    private Integer status;
    // 优惠价格
    private Double price;
    // 标题
    private String title;
    // 仅限商家信息
    private Long shopId;
    private String shopName;
    // 有效期,如果无有效期,则endTime为0
    private Long startTime;
    private Long stopTime;



    public Long getUserTicketId() {
        return userTicketId;
    }
    public void setUserTicketId(Long userTicketId) {
        this.userTicketId = userTicketId;
    }
    public Long getTicketId() {
        return ticketId;
    }
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
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
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    public Long getStopTime() {
        return stopTime;
    }
    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
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
}
