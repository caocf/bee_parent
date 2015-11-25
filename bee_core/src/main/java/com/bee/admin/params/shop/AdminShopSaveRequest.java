package com.bee.admin.params.shop;

import com.bee.pojo.shop.Shop;
import com.qsd.framework.spring.BaseRequest;

/**
 * Created by suntongwei on 15/10/25.
 */
public class AdminShopSaveRequest extends BaseRequest {

    // serialVersionUID
    private static final long serialVersionUID = -4562471258109835193L;

    /**
     * 商家信息
     */
    private Shop shop;
    /**
     * 营业开始时间小时
     */
    private String startServiceTimeHour;
    /**
     * 营业开始时间分钟
     */
    private String startServiceTimeMinute;
    /**
     * 营业结束时间小时
     */
    private String endServiceTimeHour;
    /**
     * 营业结束时间分钟
     */
    private String endServiceTimeMinute;
    /**
     * 发现文字说明
     * 只对保存新商家管用（未实现）
     */
    private String findRemark;

    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    public String getStartServiceTimeHour() {
        return startServiceTimeHour;
    }
    public void setStartServiceTimeHour(String startServiceTimeHour) {
        this.startServiceTimeHour = startServiceTimeHour;
    }
    public String getStartServiceTimeMinute() {
        return startServiceTimeMinute;
    }
    public void setStartServiceTimeMinute(String startServiceTimeMinute) {
        this.startServiceTimeMinute = startServiceTimeMinute;
    }
    public String getEndServiceTimeHour() {
        return endServiceTimeHour;
    }
    public void setEndServiceTimeHour(String endServiceTimeHour) {
        this.endServiceTimeHour = endServiceTimeHour;
    }
    public String getEndServiceTimeMinute() {
        return endServiceTimeMinute;
    }
    public void setEndServiceTimeMinute(String endServiceTimeMinute) {
        this.endServiceTimeMinute = endServiceTimeMinute;
    }
    public String getFindRemark() {
        return findRemark;
    }
    public void setFindRemark(String findRemark) {
        this.findRemark = findRemark;
    }
}
