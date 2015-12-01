package com.bee.services.shop;

import com.bee.client.params.shop.ShopReplyRequest;
import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
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
    public PagingResult<ShopReplyListItem> getAppReplyList(ShopReplyListParam req);

    /**
     *
     * @param shopReply
     * @throws DataRunException
     */
    public void saveReply(ShopReply shopReply) throws DataRunException;
}
