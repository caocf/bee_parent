package com.bee.services.shop.admin.impl;

import com.bee.admin.params.shop.AdminShopReplyRequest;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.admin.IShopReplyAdminService;
import com.bee.services.shop.impl.ShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by suntongwei on 16/4/25.
 */
@Service
public class ShopReplyAdminService extends ShopReplyService implements IShopReplyAdminService {



    /**
     * 查询评论回复列表
     *
     * @param params
     * @return
     */
    @Override
    public PagingResult<ShopReply> queryShopReplyList(AdminShopReplyRequest params) {
        return shopReplyDao.queryShopReplyList(params);
    }

    /**
     * 删除评论回复
     *
     * @param commentId
     * @param replyId
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deleteShopReply(long commentId, long replyId) throws DataRunException {
        shopReplyDao.deleteById(replyId);
        // 同时更新ShopComment的replyNum -1
        updateShopCommentReplyNum(commentId, -1);
    }

    /**
     * 保存用户回复
     *
     * @param shopReply
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void save(ShopReply shopReply) throws DataRunException {
        shopReply.setCreateTime(System.currentTimeMillis());
        shopReplyDao.save(shopReply);
        updateShopCommentReplyNum(shopReply.getShopComment().getScid(), 1);
    }
}
