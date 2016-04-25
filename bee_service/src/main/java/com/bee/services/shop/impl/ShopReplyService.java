package com.bee.services.shop.impl;

import com.bee.dao.shop.ShopCommentDao;
import com.bee.dao.shop.ShopReplyDao;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.shop.IShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/12/1.
 */
@Service
public abstract class ShopReplyService implements IShopReplyService {

    @Autowired
    protected ShopReplyDao shopReplyDao;
    @Autowired
    protected ShopCommentDao shopCommentDao;

    /**
     * 更新ShopComment的ReplyNum字段
     *
     * @param commentId 所属ShopComment
     * @param num       所调整数字, 1, -1
     */
    protected void updateShopCommentReplyNum(long commentId, int num) throws DataRunException {
        if (commentId < 1) {
            return;
        }
        ShopComment shopComment = shopCommentDao.findById(commentId);
        if (num < 0 && shopComment.getReplyNum() < 1) {
            return;
        }
        shopComment.setReplyNum(shopComment.getReplyNum() + num);
        shopCommentDao.update(shopComment);
    }
}
