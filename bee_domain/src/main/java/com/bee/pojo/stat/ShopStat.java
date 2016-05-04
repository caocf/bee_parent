package com.bee.pojo.stat;

import com.bee.pojo.shop.Shop;
import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/10/23.
 */
@Entity
@Table(name = "TB_SHOP_STAT")
public class ShopStat implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 7807338009725278185L;
    /**
     * 主键
     */
    private Long ssId;
    /**
     * 所属用户
     */
    private User user;
    /**
     * 所属商家
     */
    private Shop shop;
    /**
     * 用户标识
     */
    private String device;
    /**
     * 访问时间
     */
    private Long createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SSID", unique = true, nullable = false)
    public Long getSsId() {
        return ssId;
    }
    public void setSsId(Long ssId) {
        this.ssId = ssId;
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
    @Column(name = "DEVICE")
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
