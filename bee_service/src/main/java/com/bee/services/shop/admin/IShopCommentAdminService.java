package com.bee.services.shop.admin;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.shop.IShopCommentService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopCommentAdminService extends IShopCommentService {

    /**
     *
     * @param shopComment
     * @throws com.qsd.framework.hibernate.exception.DataRunException
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
