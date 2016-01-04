package com.bee.domain.params.party;

import com.qsd.framework.domain.request.RequestPagingApp;

/**
 * Created by suntongwei on 15/12/31.
 */
public class PartyListParam extends RequestPagingApp {

    // serialVersionUID
    private static final long serialVersionUID = 4453435711467152870L;

    // 用户ID, 用于查询用户是否参与该活动
    private Long userId;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Integer getMaxRows() {
        return 10;
    }
}
