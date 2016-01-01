package com.bee.services.shop.app;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.modal.ShopCommentListItem;
import com.bee.services.shop.IShopCommentService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/22.
 */
public interface IShopCommentAppService extends IShopCommentService {

    /**
     *
     *
     * @param request
     * @return
     */
    PagingResult<ShopCommentListItem> queryShopComment(ShopCommentRequest request);
}
