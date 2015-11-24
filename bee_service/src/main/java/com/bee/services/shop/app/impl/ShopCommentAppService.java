package com.bee.services.shop.app.impl;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.modal.ShopCommentListItem;
import com.bee.services.shop.app.IShopCommentAppService;
import com.bee.services.shop.impl.ShopCommentService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/22.
 */
@Service
public class ShopCommentAppService extends ShopCommentService implements IShopCommentAppService {

    /**
     * @param request
     * @return
     */
    @Override
    public PagingResult<ShopCommentListItem> queryShopComment(ShopCommentRequest request) {
        return shopCommentDao.queryAppShopComment(request);
    }
}
