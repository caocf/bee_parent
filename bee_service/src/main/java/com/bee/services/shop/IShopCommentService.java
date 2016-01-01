package com.bee.services.shop;

import com.bee.pojo.shop.ShopComment;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IShopCommentService {


    /**
     * 保存评论
     *
     * @param shopComment
     * @throws DataRunException
     */
    void save(ShopComment shopComment) throws DataRunException;


}
