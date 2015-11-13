package com.bee.services.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.modal.ShopCommentListItem;
import com.bee.pojo.shop.ShopComment;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/6/3.
 */
public interface IShopCommentService {


    /**
     *
     *
     * @param request
     * @return
     */
    public PagingResult<ShopCommentListItem> queryAppShopComment(ShopCommentRequest request);

    /**
     *
     *
     * @param shopComment
     */
    public void save(ShopComment shopComment) throws DataRunException;

}
