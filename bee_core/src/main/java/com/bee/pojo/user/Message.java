package com.bee.pojo.user;

import javax.persistence.*;

/**
 * Created by suntongwei on 15/12/3.
 */
@Table
@Entity(name = "TB_MESSAGE")
public class Message implements java.io.Serializable {

    // 主键
    private Long mid;
    // 消息类型
    private Integer type;
    // 消息状态
    private Integer status;
    // 消息内容
    private String msg;
    // 接受用户
    private User user;
    // 创建时间
    private Long createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MID", unique = true, nullable = false)
    public Long getMid() {
        return mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    @Column(name = "MSG")
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
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
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
