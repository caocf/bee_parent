package com.bee.pojo;

import com.bee.pojo.user.User;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/6/24.
 */
@Entity
@Table(name = "TB_ADVICE")
public class Advice implements java.io.Serializable {

    private Long aid;
    private String msg;
    private Long createTime;
    private User user;
    private String phone;
    private String device;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID", unique = true, nullable = false)
    public Long getAid() {
        return aid;
    }
    public void setAid(Long aid) {
        this.aid = aid;
    }
    @Column(name = "MSG")
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    @Column(name = "CREATETIME")
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column(name = "DEVICE")
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
}
