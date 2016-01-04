package com.bee.app.controller.party;

import com.bee.commons.Codes;
import com.bee.domain.params.party.PartyUserParam;
import com.bee.pojo.party.Party;
import com.bee.pojo.party.PartyCondition;
import com.bee.pojo.party.PartyUser;
import com.bee.pojo.user.User;
import com.bee.services.party.app.IPartyConditionAppService;
import com.bee.services.party.app.IPartyUserAppService;
import com.bee.services.user.IUserService;
import com.bee.services.user.app.IUserAppService;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by suntongwei on 16/1/5.
 */
@RestController
@RequestMapping("/v1/party/{partyId}/user")
public class PartyUserController {

    @Autowired
    private IPartyUserAppService partyUserAppService;
    @Autowired
    private IPartyConditionAppService partyConditionAppService;
    @Autowired
    private IUserAppService userAppService;

    /**
     * 参加活动
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response addParty(@PathVariable Long partyId, PartyUser partyUser) {
        Response res = new Response();
        try {
            // 判断用户是否已经报名
            PartyUserParam partyUserParam = new PartyUserParam();
            partyUserParam.setPartyId(partyId);
            partyUserParam.setUserId(partyUser.getUser().getUid());
            List<PartyUser> partyUsers = partyUserAppService.queryPartyUser(partyUserParam);
            if (partyUsers != null && partyUsers.size() > 0) {
                res.setCode(Codes.Party.PartyIsAdd);
                res.setMsg("您已经报名此活动");
                return res;
            }
            // 获取用户信息
            User user = userAppService.getUserById(partyUser.getUser().getUid());
            // 判断报名条件
            PartyCondition condition = partyConditionAppService.getPartyCondition(partyId);
            if (condition != null) {
                if (condition.getLevel() > 0 && user.getLevel() < condition.getLevel()) {
                    res.setCode(Codes.Party.PartyCondition);
                    res.setMsg("报名条件不足, 必须是等级" + condition.getLevel() + "用户");
                    return res;
                }
                if (condition.getExp() > 0 && user.getExp() < condition.getExp()) {
                    res.setCode(Codes.Party.PartyCondition);
                    res.setMsg("报名条件不足, 必须是经验大于" + condition.getExp() + "用户");
                    return res;
                }
            }
            // 保存参与活动的用户
            partyUser.setParty(new Party(partyId));
            partyUserAppService.addParty(partyUser);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("参加失败,请重试");
        }
        return res;
    }
}
