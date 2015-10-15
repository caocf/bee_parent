package com.bee.busi.params.shop;

import com.bee.pojo.shop.ShopImage;
import com.qsd.framework.spring.BaseResponse;

/**
 * Created by suntongwei on 15/10/15.
 */
public class ShopImageSaveResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = 7553709831798091706L;

    private Long shopImageId;
    private String remark;
    private String url;

    public Long getShopImageId() {
        return shopImageId;
    }

    public void setShopImageId(Long shopImageId) {
        this.shopImageId = shopImageId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
