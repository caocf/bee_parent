package com.bee.services.store;

import com.bee.admin.params.store.PhoneCardRequest;
import com.bee.pojo.store.PhoneCard;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/10/21.
 */
public interface IPhoneCardService {

    /**
     * 【A端】查询手机充值卡
     *
     * @param request
     * @return
     */
    public PagingResult<PhoneCard> queryPhoneCard(PhoneCardRequest request);

    /**
     * 【A端】保存一个手机充值卡
     *
     * @throws DataRunException
     */
    public void savePhoneCard(Long goodsId, PhoneCard phoneCard) throws DataRunException;

    /**
     * 【A端】修改一个手机充值卡
     * 只允许修改未使用的手机充值卡
     *
     * @throws DataRunException
     */
    public void updatePhoneCard(PhoneCard phoneCard) throws DataRunException;

    /**
     * 【A端】返回一个手机充值卡
     *
     * @return
     */
    public PhoneCard getPhoneCardById(long pcId);

    /**
     * 【A端】删除一个手机充值卡
     *
     * @param pcId
     * @throws DataRunException
     */
    public void deletePhoneCard(long goodsId, long pcId) throws DataRunException;

}
