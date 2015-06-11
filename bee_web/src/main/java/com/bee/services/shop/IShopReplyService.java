package com.bee.services.shop;

import com.bee.client.params.shop.ShopReplyRequest;
import com.bee.modal.ShopReplyListItem;
import com.bee.pojo.shop.ShopReply;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/6/11.
 */
public interface IShopReplyService {

    /**
     *
     * @param req
     * @return
     */
    public PagingResult<ShopReplyListItem> getAppReplyList(ShopReplyRequest req);

    /**
     *
     * @param shopReply
     * @throws DataRunException
     */
    public void saveReply(ShopReply shopReply) throws DataRunException;
}
