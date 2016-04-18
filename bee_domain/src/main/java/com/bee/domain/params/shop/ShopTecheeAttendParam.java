package com.bee.domain.params.shop;

import com.qsd.framework.domain.request.RequestApp;

/**
 * Created by suntongwei on 16/4/17.
 */
public class ShopTecheeAttendParam extends RequestApp {

    // serialVersionUID
    private static final long serialVersionUID = -1213647371377056173L;

    /**
     * 商家ID
     */
    private Long shopId;
    /**
     * 是否出勤
     * Consts.True 表示出勤
     * Consts.False 表示不出勤
     * 0: 表示无效
     */
    private Integer isAttend;

    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public Integer getIsAttend() {
        return isAttend;
    }
    public void setIsAttend(Integer isAttend) {
        this.isAttend = isAttend;
    }
}
