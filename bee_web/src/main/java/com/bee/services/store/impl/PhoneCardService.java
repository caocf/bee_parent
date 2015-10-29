package com.bee.services.store.impl;

import com.bee.admin.params.store.PhoneCardRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.dao.store.GoodsDao;
import com.bee.dao.store.PhoneCardDao;
import com.bee.pojo.store.Goods;
import com.bee.pojo.store.PhoneCard;
import com.bee.services.store.IPhoneCardService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by suntongwei on 15/10/21.
 */
@Service
public class PhoneCardService implements IPhoneCardService {

    @Autowired
    private PhoneCardDao phoneCardDao;
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 【A端】查询手机充值卡
     *
     * @param request
     * @return
     */
    @Override
    public PagingResult<PhoneCard> queryPhoneCard(PhoneCardRequest request) {
        return phoneCardDao.queryPhoneCard(request);
    }


    /**
     * 【A端】保存一个手机充值卡，并且修改Goods商品库存数量
     *
     * @param goodsId 所属商品
     * @param phoneCard 手机卡
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    @Override
    @Transactional
    public void savePhoneCard(Long goodsId, PhoneCard phoneCard) throws DataRunException {
        try {
            // 保存手机卡
            phoneCard.setStatus(Consts.Goods.PhoneCard.Status.UnUse);
            phoneCard.setCreateTime(System.currentTimeMillis());
            phoneCardDao.save(phoneCard);
            // 更新库存
            Goods goods = goodsDao.findById(goodsId);
            goods.setNumber(goods.getNumber() + 1);
            goodsDao.update(goods);
        } catch (DataRunException e) {
            throw e;
        }
    }

    /**
     * 【A端】修改一个手机充值卡
     * 只允许修改未使用的手机充值卡
     *
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void updatePhoneCard(PhoneCard phoneCard) throws DataRunException {
        if (phoneCard.getStatus() != Consts.Goods.PhoneCard.Status.UnUse) {
            throw new DataRunException(Codes.Store.PhoneCard.PhoneCardIsUsed);
        }
        phoneCardDao.update(phoneCard);
    }

    /**
     * 【A端】返回一个手机充值卡
     *
     * @return
     */
    public PhoneCard getPhoneCardById(long pcId) {
        return phoneCardDao.findById(pcId);
    }

    /**
     * 【A端】删除一个手机充值卡
     *
     * @param goodsId 所属商品ID
     * @param pcId
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void deletePhoneCard(long goodsId, long pcId) throws DataRunException {
        try {
            PhoneCard phoneCard = phoneCardDao.findById(pcId);
            goodsId = phoneCard.getOperator();
            phoneCardDao.delete(phoneCard);
            // 如果这张充值卡未使用则减去库存
            if (phoneCard.getStatus() == Consts.Goods.PhoneCard.Status.UnUse) {
                Goods goods = goodsDao.findById(goodsId);
                if (goods.getNumber() <= 0) {
                    throw new DataRunException(Codes.Store.PhoneCard.NumberEnough);
                }
                goods.setNumber(goods.getNumber() - 1);
                goodsDao.update(goods);
            }
        } catch (DataRunException e) {
            throw e;
        }
    }
}
