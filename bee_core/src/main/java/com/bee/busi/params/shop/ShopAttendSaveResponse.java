package com.bee.busi.params.shop;

import com.bee.busi.model.shop.BusiShopAttend;
import com.qsd.framework.spring.BaseResponse;

import java.util.List;

/**
 * Created by suntongwei on 15/10/17.
 */
public class ShopAttendSaveResponse extends BaseResponse {

    // serialVersionUID
    private static final long serialVersionUID = -5343226796407005986L;

    private List<BusiShopAttend> shopAttends;

    public List<BusiShopAttend> getShopAttends() {
        return shopAttends;
    }

    public void setShopAttends(List<BusiShopAttend> shopAttends) {
        this.shopAttends = shopAttends;
    }
}
