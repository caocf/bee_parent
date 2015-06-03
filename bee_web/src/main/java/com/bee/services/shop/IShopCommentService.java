package com.bee.services.shop;

import com.bee.pojo.shop.ShopComment;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/6/3.
 */
public interface IShopCommentService {

    /**
     *
     *
     * @param shopComment
     */
    public void save(ShopComment shopComment) throws DataRunException;
}
