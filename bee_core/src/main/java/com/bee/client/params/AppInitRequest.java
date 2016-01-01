package com.bee.client.params;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 15/5/11.
 */
public class AppInitRequest extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = 9219815618843321609L;

    // 上次同步时间
    private Long updateTime;
    // 用户ID
    private Long uid;
    // 用户手机类型
    private Integer phoneType;
    // 用户app版本
    private Integer version;
    // 地区最后主键
    private Long areaLastId;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getUpdateTime() {
        long curTime = System.currentTimeMillis();
        return updateTime > curTime ? curTime : updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getPhoneType() {
        return phoneType;
    }
    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Long getAreaLastId() {
        return areaLastId;
    }
    public void setAreaLastId(Long areaLastId) {
        this.areaLastId = areaLastId;
    }
}
