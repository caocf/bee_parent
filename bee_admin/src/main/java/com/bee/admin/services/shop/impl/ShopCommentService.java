package com.bee.admin.services.shop.impl;

import com.bee.admin.params.shop.AdminShopCommentRequest;
import com.bee.admin.services.shop.IShopCommentService;
import com.bee.commons.Consts;
import com.bee.commons.IntegralMachine;
import com.bee.commons.LevelMachine;
import com.bee.dao.shop.ShopCommentDao;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.ShopComment;
import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/8.
 */
@Service
public class ShopCommentService implements IShopCommentService {

    @Autowired
    private ShopCommentDao shopCommentDao;

    /**
     * 保存评论
     *
     * @param shopComment
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void save(ShopComment shopComment) throws DataRunException {
        // 保存评论
        shopComment.setCreateTime(System.currentTimeMillis());
        shopCommentDao.save(shopComment);
    }

    /**
     *【A端】查询所属商家评论列表
     *
     * @param request
     * @return
     */
    @Override
    public PagingResult<ShopComment> queryShopComment(AdminShopCommentRequest request) {
        if (null == request.getShopId() || request.getShopId() < 1) {
            return new PagingResult<>();
        }
        return shopCommentDao.queryShopComment(request);
    }}
