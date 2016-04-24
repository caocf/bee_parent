package com.bee.services.shop.admin;

import com.bee.admin.params.shop.AdminShopReplyRequest;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.IShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 16/4/25.
 */
public interface IShopReplyAdminService extends IShopReplyService {

    /**
     * 查询评论回复列表
     *
     * @param params
     * @return
     */
    PagingResult<ShopReply> queryShopReplyList(AdminShopReplyRequest params);


    /**
     * 删除评论回复
     *
     * @param replyId
     * @throws DataRunException
     */
    void deleteShopReply(long commentId, long replyId) throws DataRunException;
}
