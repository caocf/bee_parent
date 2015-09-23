package com.bee.busi.model.order;

/**
 * 商户端订单实体
 * 主要用于订单列表
 *
 * Created by suntongwei on 15/9/23.
 */
public class BusiOrderListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -7396144191076740358L;

    private Long oid;
    private String orderNo;
    private Integer status;
    private Long orderTime;
    private Integer num;
    private Long userId;
    private String userName;
    private Long createTime;
    // 历史订单数
    private Integer hisNum;

    public Long getOid() {
        return oid;
    }
    public void setOid(Long oid) {
        this.oid = oid;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Integer getHisNum() {
        return hisNum;
    }
    public void setHisNum(Integer hisNum) {
        this.hisNum = hisNum;
    }
}
