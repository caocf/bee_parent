package com.bee.domain.modal.app.order;

/**
 * <b>【C端】订单列表实体</b>
 * v1.0.5
 * 增加isBack字段
 *
 * @since v1.0.0
 */
public class OrderListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1909320038260258789L;

    private Long oid;
    private String name;
    // 下单时间
    private Long time;
    private Integer num;
    private Integer status;
    private Long shopId;
    private String userName;
    private Long execTime;
    private String phone;
    private String remark;
    // v1.0.5增加
    private Integer isBack;

    public Long getOid() {
        return oid;
    }
    public void setOid(Long oid) {
        this.oid = oid;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getTime() {
        return time;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getExecTime() {
        return execTime;
    }
    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getIsBack() {
        return isBack;
    }
    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }
}
