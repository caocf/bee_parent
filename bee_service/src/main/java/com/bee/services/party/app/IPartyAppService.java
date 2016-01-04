package com.bee.services.party.app;

import com.bee.domain.modal.app.party.PartyList;
import com.bee.domain.params.party.PartyListParam;
import com.bee.services.party.IPartyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/12/31.
 */
public interface IPartyAppService extends IPartyService {

    /**
     * 获取活动列表
     *
     * @param param
     * @return
     */
    PagingResult<PartyList> getPartyList(PartyListParam param);

}
