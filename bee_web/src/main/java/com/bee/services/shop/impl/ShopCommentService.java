package com.bee.services.shop.impl;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.commons.Consts;
import com.bee.commons.IntegralMachine;
import com.bee.dao.order.OrderDao;
import com.bee.dao.shop.ShopCommentDao;
import com.bee.dao.user.UserDao;
import com.bee.modal.ShopCommentListItem;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.user.User;
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
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Override
    public PagingResult<ShopCommentListItem> queryAppShopComment(ShopCommentRequest request) {
        return shopCommentDao.queryAppShopComment(request);
    }

    /**
     * 保存评论
     *
     * @param shopComment
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void save(ShopComment shopComment) throws DataRunException {

        // 完成订单追加积分奖励
        if (shopComment.getOrder() != null && shopComment.getOrder().getOid() > 0) {
            // 保证是订单评论
            Order order = orderDao.findById(shopComment.getOrder().getOid());
            // 判断该订单是否已经有过评论，并且该订单需要是完成状态
            if (order.getIsComment() == Consts.False && order.getStatus() == Consts.Order.Status.Finish) {
                // 并且存在用户
                if (shopComment.getUser() != null && shopComment.getUser().getUid() > 0) {

                    // 增加用户积分
                    User user = userDao.findById(shopComment.getUser().getUid());
                    user.addIntegral(IntegralMachine.OrderComment);
                    userDao.update(user);

                    // 完成订单评论
                    order.setIsComment(Consts.True);
                    orderDao.update(order);
                }
            }
        }

        // 保存评论
        shopComment.setCreateTime(System.currentTimeMillis());
        shopCommentDao.save(shopComment);
    }
}
