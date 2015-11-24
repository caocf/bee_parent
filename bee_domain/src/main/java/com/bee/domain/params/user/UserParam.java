package com.bee.domain.params.user;

import com.qsd.framework.spring.BaseRequest;

/**
 * Created by suntongwei on 15/11/15.
 */
public class UserParam extends BaseRequest {

    // serialVersionUID
    private static final long serialVersionUID = 3021859094426738264L;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 昵称
     */
    private String nick;

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
}
