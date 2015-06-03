package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopCommentDao;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.shop.IShopCommentService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/6/3.
 */
@Service
public class ShopCommentService implements IShopCommentService {

    @Autowired
    private ShopCommentDao shopCommentDao;

    @Override
    @Transactional
    public void save(ShopComment shopComment) throws DataRunException {
        shopCommentDao.save(shopComment);
    }
}
