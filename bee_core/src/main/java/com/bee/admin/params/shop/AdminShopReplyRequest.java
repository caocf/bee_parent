package com.bee.admin.params.shop;

import com.qsd.framework.domain.request.RequestPaging;

/**
 * Created by suntongwei on 16/4/25.
 */
public class AdminShopReplyRequest extends RequestPaging {

    // serialVersionUID
    private static final long serialVersionUID = -561718740206973572L;

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
