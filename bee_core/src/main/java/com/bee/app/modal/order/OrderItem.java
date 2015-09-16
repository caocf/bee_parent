package com.bee.app.modal.order;

/**
 * Created by suntongwei on 15/9/16.
 */
public class OrderItem implements java.io.Serializable {

    private static final long serialVersionUID = 6210947803471133096L;

    // 订单编号
    private String no;
    // 商家地址
    private String addr;
    // 订单状态
    private Integer status;

    // 创建时间
    private Long createTime;

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
}
