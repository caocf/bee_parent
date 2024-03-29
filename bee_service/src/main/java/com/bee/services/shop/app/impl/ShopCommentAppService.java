package com.bee.services.shop.app.impl;

import com.bee.client.params.shop.ShopCommentRequest;
import com.bee.commons.Consts;
import com.bee.commons.IntegralMachine;
import com.bee.commons.LevelMachine;
import com.bee.dao.order.OrderDao;
import com.bee.dao.user.UserDao;
import com.bee.modal.ShopCommentListItem;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.user.User;
import com.bee.services.shop.app.IShopCommentAppService;
import com.bee.services.shop.impl.ShopCommentService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/22.
 */
@Service
public class ShopCommentAppService extends ShopCommentService implements IShopCommentAppService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;

    /**
     * @param request
     * @return
     */
    @Override
    public PagingResult<ShopCommentListItem> queryShopComment(ShopCommentRequest request) {
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
        // 是否订单评论
        boolean isOrderExpAdd = false;

        User user = null;
        if (shopComment.getUser() != null && shopComment.getUser().getUid() > 0) {
            user = userDao.findById(shopComment.getUser().getUid());
        }

        // 完成订单追加积分奖励
        if (shopComment.getOrder() != null && shopComment.getOrder().getOid() > 0) {
            // 保证是订单评论
            Order order = orderDao.findById(shopComment.getOrder().getOid());
            // 判断该订单是否已经有过评论，并且该订单需要是完成状态
            if (order.getIsComment() == Consts.False && order.getStatus() == Consts.Order.Status.Finish) {
                // 并且存在用户
                if (user != null) {
                    // 增加用户积分
                    user.addIntegral(IntegralMachine.OrderComment);
                    user.addExp(LevelMachine.OrderComment);
                    userDao.update(user);

                    // 标识订单评论已增加经验
                    isOrderExpAdd = true;

                    // 完成订单评论
                    order.setIsComment(Consts.True);
                    orderDao.update(order);
                }
            }
        } else {
            shopComment.setOrder(new Order(0));
        }

        // 保存评论
        shopComment.setCreateTime(System.currentTimeMillis());
        shopCommentDao.save(shopComment);

        // 增加用户经验，并且并不是订单评论，因订单评论已增加经验
        if (!isOrderExpAdd && user != null) {
            user.addExp(LevelMachine.Comment);
            userDao.update(user);
        }
    }
}
