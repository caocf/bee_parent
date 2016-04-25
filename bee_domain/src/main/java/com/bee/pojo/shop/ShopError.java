package com.bee.pojo.shop;

import com.bee.commons.Consts;
import com.bee.pojo.user.User;
import com.qsd.framework.commons.utils.DateUtil;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/16.
 */
@Entity
@Table(name = "TB_SHOP_ERROR")
public class ShopError implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 65344651226807160L;

    /**
     * 主键
     */
    private Long seid;
    /**
     * 错误消息
     */
    private String errorMsg;
    /**
     * 类型(未使用)
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 所属用户
     */
    private User user;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 所属商家
     */
    private Shop shop;

    @Transient
    public String getStatusStr() {
        if(status == Consts.Shop.ErrorStatus.End) {
            return "已完成";
        } else if(status == Consts.Shop.ErrorStatus.Doing) {
            return "处理中";
        } else {
            return "未处理";
        }
    }

    @Transient
    public String getCreateTimeStr() {
        return DateUtil.formatDateTime(createTime);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEID", unique = true, nullable = false)
    public Long getSeid() {
        return seid;
    }
    public void setSeid(Long seid) {
        this.seid = seid;
    }
    @Column(name = "ERRORMSG")
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP")
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}