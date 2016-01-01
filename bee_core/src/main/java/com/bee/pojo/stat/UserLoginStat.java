package com.bee.pojo.stat;

import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/4/16.
 */
@Entity
@Table(name = "TB_USER_LOGIN_STAT")
public class UserLoginStat implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1522261428943367989L;

    /**
     * 主键
     */
    private Long ulsId;
    /**
     * 所属用户
     */
    private User user;
    /**
     * 用户标识
     */
    private String device;
    /**
     * 登录时间
     */
    private Long createTime;
    /**
     * 手机类型
     */
    private Integer phoneType;
    /**
     * app版本号
     */
    private Integer appVer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ULSID", unique = true, nullable = false)
    public Long getUlsId() {
        return ulsId;
    }
    public void setUlsId(Long ulsId) {
        this.ulsId = ulsId;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "PHONETYPE")
    public Integer getPhoneType() {
        return phoneType;
    }
    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }
    @Column(name = "APPVER")
    public Integer getAppVer() {
        return appVer;
    }
    public void setAppVer(Integer appVer) {
        this.appVer = appVer;
    }
}
