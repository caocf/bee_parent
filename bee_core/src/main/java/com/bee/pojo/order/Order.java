package com.bee.pojo.order;

import com.bee.commons.Consts;
import com.bee.pojo.shop.Shop;
import com.bee.pojo.shop.ShopUser;
import com.bee.pojo.tickets.UserTicket;
import com.bee.pojo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qsd.framework.commons.utils.DateUtil;
import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by suntongwei on 15/4/24.
 */
@Entity
@Table(name = "TB_ORDER")
@JsonIgnoreProperties(value = {"userTickets"})
public class Order implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8029904732374050196L;
    // 主键
    private Long oid;
    // 订单编号
    private String no;
    // 订单类型
    private Integer type;
    // 订单状态
    private Integer status;
    // 人数
    private Integer num;
    // 预约时间
    private Long execTime;
    // 说明
    private String remark;
    // 联系人
    private String orderName;
    // 联系电话
    private String orderPhone;
    // 用户识别号
    private String device;
    // 提交人
    private User user;
    // 所属店
    private Shop shop;
    // 商家接待管理员
    private ShopUser shopUser;
    // 订单创建时间
    private Long createTime;
    // 是否点评订单
    private Integer isComment;
    // 订单结束时间
    private Long finishTime;
    // 订单操作记录
    private String operate;
    // 是否返现 v1.0.5增加
    private Integer isBack;
    // 所使用优惠券/红包
    private Set<UserTicket> userTickets = new HashSet<>();

    public Order() {}
    public Order(long oid) {
        this.oid = oid;
    }

    /**
     * 写入操作日志
     *
     * @param operate
     */
    @Transient
    @JsonIgnore
    public void writeOperate(String operate) {
        if (this.operate != null && !"".equals(this.operate)) {
            this.operate += ";";
        } else {
            this.operate = "";
        }
        this.operate += DateUtil.formatDateTime(System.currentTimeMillis()) + operate;
    }

    @Transient
    public String getTypeStr() {
        String ret = "";
        switch (getType()) {
            case Consts.Order.Type.Master:
                ret = "主订单";
                break;
            case Consts.Order.Type.Child:
                ret = "子订单";
                break;
        }
        return ret;
    }

    @Transient
    public String getExecTimeStr() {
        return DateUtil.formatDate(new Date(getExecTime()), Consts.Order.ExecTimeType);
    }

    @Transient
    public String getStatusStr() {
        return Consts.Order.Status.getStatusName(status);
    }

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(getCreateTime());
    }
    @Transient
    public String getCreateTimeIng() {
        return DateUtil.formatBbsTime(getCreateTime());
    }

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
    @Column(name = "DEVICE")
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
    @Column(name = "ORDERNAME")
    public String getOrderName() {
        return orderName;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    @Column(name = "ORDERPHONE")
    public String getOrderPhone() {
        return orderPhone;
    }
    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOPUSER")
    public ShopUser getShopUser() {
        try {
            return shopUser;
        } catch (Exception e) {
            return new ShopUser(0);
        }
    }
    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }
    @Column(name = "ISCOMMENT")
    public Integer getIsComment() {
        return isComment;
    }
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }
    @Column(name = "FINISHTIME")
    public Long getFinishTime() {
        return finishTime;
    }
    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }
    @Column(name = "OPERATE")
    public String getOperate() {
        return operate;
    }
    public void setOperate(String operate) {
        this.operate = operate;
    }
    @Column(name = "ISBACK")
    public Integer getIsBack() {
        return isBack;
    }
    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
    }
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "order")
    public Set<UserTicket> getUserTickets() {
        return userTickets;
    }
    public void setUserTickets(Set<UserTicket> userTickets) {
        this.userTickets = userTickets;
    }
}
