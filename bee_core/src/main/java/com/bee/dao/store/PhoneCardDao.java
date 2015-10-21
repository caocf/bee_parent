package com.bee.dao.store;

import com.bee.commons.SQL;
import com.bee.pojo.store.PhoneCard;
import com.qsd.framework.hibernate.JpaDaoSupport;
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


}
