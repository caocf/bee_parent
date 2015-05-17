package com.bee.pojo.user;

import com.bee.commons.Consts;
import com.bee.commons.ImageFactory;
import com.bee.pojo.shop.ShopFocus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qsd.framework.security.entity.ISecurityUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by suntongwei on 15/4/15.
 */
@Entity
@Table(name = "TB_USER")
@JsonIgnoreProperties(value = {"password", "shopFocus"})
public class User implements java.io.Serializable, ISecurityUser {

    // serialVersionUID
    private static final long serialVersionUID = -6828211966689874833L;

    // 用户ID
    private Long uid;
    // 用户头像图片
    private String url;
    private String path;
    // 手机标识(imei号或IOS编号)
    private String device;
    // 用户名
    private String name;
    // 手机
    private String phone;
    // 用户类型
    private Integer type;
    // 密码
    private String password;
    // 注册时间
    private Long createTime;
    // 支付宝账户
    private String alipay;
    // 用户等级
    private Integer level;
    // 用户积分
    private Integer integral;
    // 用户关注的商家
    private Set<ShopFocus> shopFocus = new HashSet<ShopFocus>(0);

    @Override
    @Transient
    public String getIdentity() {
        if(null == getUid() || getUid() <= 0) {
            return "";
        }
        return String.valueOf(Consts.User.IdentityBaseNum + getUid());
    }

    public User(){}
    public User(Long uid) {
        this.uid = uid;
    }

    @Transient
    public ImageFactory.Image getImage() {
        return new ImageFactory.Image(getUrl(), ImageFactory.ImageType.UserImage);
    }

    @Override
    @Transient
    public Set<String> getAuthName() {
        return null;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UID", unique = true, nullable = false)
    public Long getUid() {
        return uid;
    }
    @Override
    @Transient
    public String getEmail() {
        return null;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }
    @Override
    @Transient
    public Integer getEmailOrPhone() {
        return null;
    }
    @Override
    @Transient
    public String getRealName() {
        return null;
    }
    @Override
    @Transient
    public String getPinyinName() {
        return null;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "ALIPAY")
    public String getAlipay() {
        return alipay;
    }
    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }
    @Column(name = "LEVEL")
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    @Column(name = "INTEGRAL")
    public Integer getIntegral() {
        return integral;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "user")
    public Set<ShopFocus> getShopFocus() {
        return shopFocus;
    }
    public void setShopFocus(Set<ShopFocus> shopFocus) {
        this.shopFocus = shopFocus;
    }
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
