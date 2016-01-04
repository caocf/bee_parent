package com.bee.services.party.app.impl;

import com.bee.commons.Consts;
import com.bee.dao.party.PartyUserDao;
import com.bee.dao.party.app.PartyAppDao;
import com.bee.domain.modal.app.party.PartyList;
import com.bee.domain.params.party.PartyListParam;
import com.bee.domain.params.party.PartyUserParam;
import com.bee.pojo.party.PartyUser;
import com.bee.services.party.app.IPartyAppService;
import com.bee.services.party.impl.PartyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/12/31.
 */
@Service
public class PartyAppService extends PartyService implements IPartyAppService {

    @Autowired
    private PartyAppDao partyAppDao;
    @Autowired
    private PartyUserDao partyUserDao;

    /**
     * 获取活动列表
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<PartyList> getPartyList(PartyListParam param) {
        PagingResult<PartyList> result = partyAppDao.getPartyList(param);
        if (param.getUserId() != null && param.getUserId() > 0
                && result.getData() != null && result.getData().size() > 0) {
            PartyUserParam partyUserParam = new PartyUserParam();
            partyUserParam.setUserId(param.getUserId());
            for (PartyList partyList : result.getData()) {
                partyUserParam.setPartyId(partyList.getPid());
                List<PartyUser> users = partyUserDao.queryPartyUser(partyUserParam);
                partyList.setIsApply(
                        users != null && users.size() > 0 ? Consts.True : Consts.False);
            }
        }
        return result;
    }

}
