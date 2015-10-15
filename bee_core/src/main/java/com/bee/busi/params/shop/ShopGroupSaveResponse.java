package com.bee.busi.params.shop;

import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/10/15.
 */
public class ShopGroupSaveResponse extends BaseResponse {

    private static final long serialVersionUID = -1018667924076485818L;

    private Long shopGroupId;

    public Long getShopGroupId() {
        return shopGroupId;
    }
    public void setShopGroupId(Long shopGroupId) {
        this.shopGroupId = shopGroupId;
    }
}
