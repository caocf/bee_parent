package com.bee.domain.params.user;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 16/1/1.
 */
public class MessageParam extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = -6746622006004465470L;

    // 用户ID
    private Long uid;
    // 最后更新时间
    private Long lastUpdateTime;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
