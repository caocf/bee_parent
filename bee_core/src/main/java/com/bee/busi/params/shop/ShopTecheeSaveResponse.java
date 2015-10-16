package com.bee.busi.params.shop;

import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/10/16.
 */
public class ShopTecheeSaveResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = 1052570754292097707L;


    private Long shopTecheeId;

    public Long getShopTecheeId() {
        return shopTecheeId;
    }

    public void setShopTecheeId(Long shopTecheeId) {
        this.shopTecheeId = shopTecheeId;
    }
}
