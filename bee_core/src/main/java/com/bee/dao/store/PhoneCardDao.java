package com.bee.dao.store;

import com.bee.admin.params.store.PhoneCardRequest;
import com.bee.commons.SQL;
import com.bee.pojo.store.PhoneCard;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/10/21.
 */
@Repository
public class PhoneCardDao extends JpaDaoSupport<PhoneCard, Long> {

    /**
     * 返回一张有效的手机卡
     *
     * @param operator 运营商
     * @return
     */
    public PhoneCard getEffectivePhoneCard(int operator) {
        return findFirstByParams(SQL.Store.GetEffectivePhoneCard, operator);
    }


    /**
     * 【A端】查询手机充值卡
     *
     * @param request
     * @return
     */
    public PagingResult<PhoneCard> queryPhoneCard(PhoneCardRequest request) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Store.PhoneCard.QueryPhoneCard);
        if (request != null) {
            if (request.getGoodsId() != null && request.getGoodsId() > 0) {
                // 暂时使用ID做为Operator
                sb.append(" and A.operator = ?");
                entity.setParam(request.getGoodsId().intValue());
            }
        }
        entity.setPaging(request);
        entity.setEntity(sb);
        return queryWithPaging(entity);
    }

}
