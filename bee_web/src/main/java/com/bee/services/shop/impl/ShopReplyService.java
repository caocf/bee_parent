package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopCommentDao;
import com.bee.dao.shop.app.ShopReplyAppDao;
import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
import com.bee.pojo.shop.ShopComment;
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
    private ShopReplyAppDao shopReplyDao;
    @Autowired
    private ShopCommentDao shopCommentDao;

    /**
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<ShopReplyListItem> getAppReplyList(ShopReplyListParam req) {
        return shopReplyDao.getReplyListForApp(req);
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
        // 并且对ShopComment的ReplyNum +1
        ShopComment shopComment = shopCommentDao.findById(shopReply.getShopComment().getScid());
        shopComment.setReplyNum(shopComment.getReplyNum() + 1);
        shopCommentDao.update(shopComment);
    }
}
