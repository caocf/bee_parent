package com.bee.domain.modal.app.user;

/**
 * Created by suntongwei on 16/1/1.
 */
public class MessageList implements java.io.Serializable {

    // 主键
    private Long mid;
    // 消息类型
    private Integer type;
    // 消息内容
    private String msg;
    // 接受用户
    private Long user;
    // 创建时间
    private Long createTime;


    public Long getMid() {
        return mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Long getUser() {
        return user;
    }
    public void setUser(Long user) {
        this.user = user;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
