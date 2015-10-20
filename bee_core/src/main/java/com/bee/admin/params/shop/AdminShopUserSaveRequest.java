package com.bee.admin.params.shop;

import com.qsd.framework.spring.BaseRequest;

/**
 * Created by suntongwei on 15/10/20.
 */
public class AdminShopUserSaveRequest extends BaseRequest {

    // serialVersionUID
    private static final long serialVersionUID = -6754037266639561115L;

    // 用户账户
    private String account;
    // 用户名
    private String name;
    // 所属商家
    private Long shopId;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
