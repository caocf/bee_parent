package com.bee.pojo.order;

import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/24.
 */
@Entity
@Table(name = "TB_ORDER")
public class Order implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8029904732374050196L;
    // 主键
    private Long oid;
    // 订单编号
    private String no;
    // 订单类型=商家类型
    private Integer type;
    // 订单状态
    private Integer status;
    // 人数
    private Integer num;
    // 预约时间
    private Long execTime;
    // 说明
    private String remark;
    // 提交人
    private User user;
    // 所属店
    private Shop shop;
    // 订单创建时间
    private Long createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID", unique = true, nullable = false)
    public Long getOid() {
        return oid;
    }
    public void setOid(Long oid) {
        this.oid = oid;
    }
    @Column(name = "NO")
    public String getNo() {
        if(getOid() != null && (null == no || "".equals(no))) {
            setNo(String.valueOf(10000 + getOid()));
        }
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name = "NUM")
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    @Column(name = "EXECTIME")
    public Long getExecTime() {
        return execTime;
    }
    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }
    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
