package com.bee.services.party;

import com.bee.domain.params.party.PartyUserParam;
import com.bee.pojo.party.PartyUser;

import java.util.List;

/**
 * Created by suntongwei on 16/1/5.
 */
public interface IPartyUserService {

    /**
     * 查询活动用户
     *
     * @param param
     * @return
     */
    List<PartyUser> queryPartyUser(PartyUserParam param);


}
