package com.bee.domain.response;

import com.qsd.framework.domain.response.Response;

/**
 * Created by suntongwei on 15/12/1.
 */
public class ServiceSupportResponse extends Response {

    // serialVersionUID
    private static final long serialVersionUID = 3980714434035746533L;

    // 是否提供刷卡
    private Integer isPosCard;
    // 是否提供免费停车
    private Integer isFreeParking;
    // 是否提供餐饮
    private Integer isFood;
    // 是否提供发票
    private Integer isInvoice;


    public Integer getIsPosCard() {
        return isPosCard;
    }
    public void setIsPosCard(Integer isPosCard) {
        this.isPosCard = isPosCard;
    }
    public Integer getIsFreeParking() {
        return isFreeParking;
    }
    public void setIsFreeParking(Integer isFreeParking) {
        this.isFreeParking = isFreeParking;
    }
    public Integer getIsFood() {
        return isFood;
    }
    public void setIsFood(Integer isFood) {
        this.isFood = isFood;
    }
    public Integer getIsInvoice() {
        return isInvoice;
    }
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }
}
