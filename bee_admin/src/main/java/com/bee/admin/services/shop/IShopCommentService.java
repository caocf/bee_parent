package com.bee.admin.services.shop;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.pojo.shop.ShopComment;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/8.
 */
public interface IShopCommentService {

    /**
     *
     * @param shopComment
     * @throws DataRunException
     */
    void save(ShopComment shopComment) throws DataRunException;

    /**
     *【A端】查询所属商家评论列表
     *
     * @param request
     * @return
     */
    PagingResult<ShopComment> queryShopComment(AdminShopCommentRequest request);
}
