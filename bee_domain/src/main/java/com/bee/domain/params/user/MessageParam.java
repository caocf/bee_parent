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
    // 消息状态
    private Integer status;

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
