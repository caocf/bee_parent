package com.bee.app.controller.party;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.party.PartyList;
import com.bee.domain.params.party.PartyListParam;
import com.bee.services.party.app.IPartyAppService;
import com.qsd.framework.domain.response.ResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/12/25.
 */
@RestController
@RequestMapping(value = "/v1/party")
public class PartyController {

    @Autowired
    private IPartyAppService partyAppService;

    /**
     * 获取活动列表
     *
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<PartyList> getPartyList(PartyListParam param) {
        ResponsePaging<PartyList> res = new ResponsePaging<>();
        res.setResult(partyAppService.getPartyList(param));
        res.setCode(Codes.Success);
        return res;
    }

}
