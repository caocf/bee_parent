package com.bee.client.params.shop;

import com.qsd.framework.spring.PagingRequest;

/**
 * Created by suntongwei on 15/6/12.
 */
public class ShopReplyRequest extends PagingRequest {

    private static final long serialVersionUID = -7809396062073044526L;

    private Long shopId;
    private Long commentId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Override
    public Integer getMaxRows() {
        return 15;
    }
}
