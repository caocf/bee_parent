package com.bee.services.party.app.impl;

import com.bee.dao.party.app.PartyAppDao;
import com.bee.domain.modal.app.party.PartyList;
import com.bee.domain.params.party.PartyListParam;
import com.bee.services.party.app.IPartyAppService;
import com.bee.services.party.impl.PartyService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/12/31.
 */
@Service
public class PartyAppService extends PartyService implements IPartyAppService {

    @Autowired
    private PartyAppDao partyAppDao;

    /**
     * 获取活动列表
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<PartyList> getPartyList(PartyListParam param) {
        return partyAppDao.getPartyList(param);
    }
}
