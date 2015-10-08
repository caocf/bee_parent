package com.bee.busi.params.shop;

import com.qsd.framework.spring.AppRequest;

/**
 * Created by suntongwei on 15/10/8.
 */
public class ShopAttendSaveRequest extends AppRequest {

    // serialVersionUID
    private static final long serialVersionUID = -1322584574751459682L;

    private Long[] techeeIds;
    private Long attendTime;
    private Long shopId;

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Long[] getTecheeIds() {
        return techeeIds;
    }
    public void setTecheeIds(Long[] techeeIds) {
        this.techeeIds = techeeIds;
    }
    public Long getAttendTime() {
        return attendTime;
    }
    public void setAttendTime(Long attendTime) {
        this.attendTime = attendTime;
    }
}
