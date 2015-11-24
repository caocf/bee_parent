package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopCommentDao;
import com.bee.services.shop.IShopCommentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class ShopCommentService implements IShopCommentService {

    @Autowired
    protected ShopCommentDao shopCommentDao;
}
