package com.bee.busi.model.order;

/**
 * Created by suntongwei on 15/10/1.
 */
public class BusiOrderItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -856813537978035515L;

    // 订单ID
    private Long oid;
    // 订单编号
    private String no;
    // 商家地址
    private String addr;
    // 订单状态
    private Integer status;
    // 创建时间
    private Long createTime;
    // 预约时间
    private Long execTime;
    // 人数
    private Integer num;
    // 用户名
    private String userName;
    // 用户电话
    private String userPhone;
    // 用户ID
    private Long userId;
    // 备注
    private String remark;
    // 用户级别
    private Integer userLevel;

    public Long getOid() {
        return oid;
    }
    public void setOid(Long oid) {
        this.oid = oid;
    }
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
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public Long getExecTime() {
        return execTime;
    }
    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
}
