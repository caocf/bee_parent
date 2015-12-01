package com.bee.app.controller.finds;

import com.bee.commons.Codes;
import com.bee.domain.modal.app.find.FindReplyItem;
import com.bee.domain.params.find.FindReplyParam;
import com.bee.pojo.find.Find;
import com.bee.pojo.find.FindReply;
import com.bee.services.find.app.IFindReplyAppService;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/12/1.
 */
@RestController
@RequestMapping("/v1/find/{findId}/reply")
public class FindReplyController {

    @Autowired
    private IFindReplyAppService findReplyAppService;

    /**
     *
     * @param findId
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponsePaging<FindReplyItem> getAppReplyList(@PathVariable Long findId, FindReplyParam req) {
        ResponsePaging<FindReplyItem> res = new ResponsePaging<>();
        req.setFindId(findId);
        res.setResult(findReplyAppService.getFindReplyForApp(req));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     *
     * @param findId
     * @param reply
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response save(@PathVariable Long findId, FindReply reply) {
        Response res = new Response();
        if (StringUtil.checkIllegalChar(reply.getContent())) {
            res.setCode(Codes.Success);
            res.setMsg("内容包含非法字符");
            return res;
        }
        try {
            reply.setFind(new Find(findId));
            findReplyAppService.save(reply);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("回复失败,请重试");
        }
        return res;
    }
}
