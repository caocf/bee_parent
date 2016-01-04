package com.bee.domain.params.party;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 16/1/5.
 */
public class PartyUserParam extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = -4051890327847878151L;

    // 指定活动
    private Long partyId;
    // 查询指定用户
    private Long userId;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getPartyId() {
        return partyId;
    }
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
