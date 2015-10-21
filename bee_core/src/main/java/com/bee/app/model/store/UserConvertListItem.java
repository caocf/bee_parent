package com.bee.app.model.store;

/**
 * Created by suntongwei on 15/10/21.
 */
public class UserConvertListItem implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2689169221132966122L;

    // 商品名
    private String goodsName;
    // 所消耗积分
    private Integer integral;
    // 手机卡密
    private String cardNumber;
    // 兑换时间
    private Long createTime;


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
