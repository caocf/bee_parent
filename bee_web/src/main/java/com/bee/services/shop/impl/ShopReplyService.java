package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopReplyRequest;
import com.bee.dao.shop.ShopReplyDao;
import com.bee.modal.ShopReplyListItem;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.IShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/6/11.
 */
@Service
public class ShopReplyService implements IShopReplyService {

    @Autowired
    private ShopReplyDao shopReplyDao;

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<ShopReplyListItem> getAppReplyList(ShopReplyRequest req) {
        return shopReplyDao.getAppReplyList(req);
    }

    /**
     *
     * @param shopReply
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void saveReply(ShopReply shopReply) throws DataRunException {
        shopReply.setCreateTime(System.currentTimeMillis());
        shopReplyDao.save(shopReply);
    }
}
