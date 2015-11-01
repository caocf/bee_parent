package com.bee.admin.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/10/29.
 */
public class AdminShopCommentRequest extends PagingRequest {

    // serialVersionUID
    private static final long serialVersionUID = 9125367105481174556L;

    // 所属商家ID（必须），不支持查询所有评论
    private Long shopId;
    // 商家名，仅限前台使用
    private String shopName;


    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
