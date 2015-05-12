package com.bee.client.params;

import com.qsd.framework.spring.AppRequest;

/**
 * Created by suntongwei on 15/5/11.
 */
public class AppInitRequest extends AppRequest {

    // serialVersionUID
    private static final long serialVersionUID = 9219815618843321609L;

    // 上次同步时间
    private Long updateTime;

    public Long getUpdateTime() {
        long curTime = System.currentTimeMillis();
        return updateTime > curTime ? curTime : updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
