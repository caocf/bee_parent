package com.bee.services.store.impl;

import com.bee.app.model.store.UserConvertListItem;
import com.bee.app.params.store.UserConvertQueryRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.dao.store.GoodsDao;
import com.bee.dao.store.PhoneCardDao;
import com.bee.dao.store.UserConvertDao;
import com.bee.dao.user.UserDao;
import com.bee.pojo.store.Goods;
import com.bee.pojo.store.PhoneCard;
import com.bee.pojo.store.UserConvert;
import com.bee.pojo.user.User;
import com.bee.services.store.IUserConvertService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/10/21.
 */
@Service
public class UserConvertService implements IUserConvertService {

    @Autowired
    private UserConvertDao userConvertDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private PhoneCardDao phoneCardDao;

    @Autowired
    private UserDao userDao;


    /**
     * 兑换商品
     *
     * @param uid
     * @param goodsId
     */
    @Override
    @Transactional
    public synchronized void saveUserConvert(long uid, long goodsId) throws DataRunException {

        // 获取商品
        Goods goods = goodsDao.findById(goodsId);

        if (goods.getNumber() < 1) {
            throw new DataRunException(Codes.Store.StockError);
        }

        // 获取手机充值卡
        PhoneCard phoneCard = null;
        if (goods.getGid() == 1) {
            phoneCard = phoneCardDao.getEffectivePhoneCard(Consts.Operator.ChinaMobile);
        } else if (goods.getGid() == 2) {
            phoneCard = phoneCardDao.getEffectivePhoneCard(Consts.Operator.ChinaUnicom);
        } else if (goods.getGid() == 3) {
            phoneCard = phoneCardDao.getEffectivePhoneCard(Consts.Operator.ChinaTelecom);
        }

        if (null == phoneCard) {
            throw new DataRunException(Codes.Store.StockError);
        }

        // 判断有没有足够积分
        User user = userDao.findById(uid);
        int afterIntegral = user.getIntegral() - goods.getIntegral();
        if (afterIntegral < 0) {
            throw new DataRunException(Codes.Store.IntegralNotEnough);
        }

        try {

            // 修改用户积分
            user.setIntegral(afterIntegral);
            userDao.update(user);

            // 保存兑换记录
            UserConvert userConvert = new UserConvert();
            userConvert.setUser(new User(uid));
            userConvert.setCardNumber(phoneCard.getCardNumber());
            userConvert.setGoods(goods);
            userConvert.setCreateTime(System.currentTimeMillis());
            userConvertDao.save(userConvert);

            // 标记卡已被兑换
            phoneCard.setStatus(Consts.False);
            phoneCardDao.update(phoneCard);

            // 修改库存
            goods.setNumber(goods.getNumber() - 1);
            goodsDao.update(goods);

        } catch (DataRunException e) {
            throw e;
        }

    }

    /**
     * 查询兑换记录
     *
     * @param req
     * @return
     */
    @Override
    public PagingResult<UserConvertListItem> queryUserConverList(UserConvertQueryRequest req) {
        return userConvertDao.queryUserConverList(req);
    }
}
