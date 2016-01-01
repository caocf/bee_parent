package com.bee.services.shop;

import com.bee.pojo.shop.ShopReply;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/12/1.
 */
public interface IShopReplyService {


    /**
     * 保存商家评论回复
     *
     * @param shopReply
     * @throws DataRunException
     */
    void save(ShopReply shopReply) throws DataRunException;
}
