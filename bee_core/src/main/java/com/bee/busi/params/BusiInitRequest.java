package com.bee.busi.params;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 15/10/26.
 */
public class BusiInitRequest extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = -4825820946112041993L;

    private Long sid;
    private Long updateTime;
    private String phone;
    private String password;

    // v1.1 增加
    // 技师数据同步时间标识
    private Long updateTechee;

    public Long getSid() {
        return sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    public Long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getUpdateTechee() {
        return updateTechee;
    }
    public void setUpdateTechee(Long updateTechee) {
        this.updateTechee = updateTechee;
    }
}
