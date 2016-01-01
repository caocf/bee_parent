package com.bee.services.shop.app;

import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.IShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/12/1.
 */
public interface IShopReplyAppService extends IShopReplyService {

    /**
     * 查询评论回复列表
     *
     * @param param
     * @return
     */
    PagingResult<ShopReplyListItem> getReplyList(ShopReplyListParam param);


}
