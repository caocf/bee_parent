package com.bee.services.shop.app.impl;

import com.bee.dao.shop.app.ShopReplyAppDao;
import com.bee.domain.modal.app.shop.ShopReplyListItem;
import com.bee.domain.params.shop.ShopReplyListParam;
import com.bee.pojo.shop.ShopReply;
import com.bee.services.shop.app.IShopReplyAppService;
import com.bee.services.shop.impl.ShopReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/12/1.
 */
@Service
public class ShopReplyAppService extends ShopReplyService implements IShopReplyAppService {

    @Autowired
    private ShopReplyAppDao shopReplyAppDao;


    @Override
    public PagingResult<ShopReplyListItem> getReplyList(ShopReplyListParam param) {
        return shopReplyAppDao.getReplyListForApp(param);
    }

    /**
     * 保存评论
     *
     * @param shopReply
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void save(ShopReply shopReply) throws DataRunException {
        shopReply.setCreateTime(System.currentTimeMillis());
        shopReplyAppDao.save(shopReply);
        // 更新ShopComment的ReplyNum+1
        updateShopCommentReplyNum(shopReply.getShopComment().getScid(), 1);
    }
}
