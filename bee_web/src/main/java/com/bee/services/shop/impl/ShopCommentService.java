package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.dao.shop.ShopCommentDao;
import com.bee.modal.ShopCommentListItem;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.shop.IShopCommentService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
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
    public PagingResult<ShopCommentListItem> queryAppShopComment(ShopCommentRequest request) {
        return shopCommentDao.queryAppShopComment(request);
    }

    @Override
    @Transactional
    public void save(ShopComment shopComment) throws DataRunException {
        shopComment.setCreateTime(System.currentTimeMillis());
        shopCommentDao.save(shopComment);
    }
}
