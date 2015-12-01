package com.bee.domain.params.shop;

import com.qsd.framework.domain.request.RequestApp;
import com.qsd.framework.domain.request.RequestPagingApp;

/**
 * Created by suntongwei on 15/12/1.
 */
public class ShopReplyListParam extends RequestPagingApp {

    // serialVersionUID
    private static final long serialVersionUID = -7944936221352924432L;

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
