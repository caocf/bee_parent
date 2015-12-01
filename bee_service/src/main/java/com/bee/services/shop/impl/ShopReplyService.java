package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopReplyDao;
import com.bee.services.shop.IShopReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/12/1.
 */
@Service
public abstract class ShopReplyService implements IShopReplyService {

    @Autowired
    protected ShopReplyDao shopReplyDao;
}
