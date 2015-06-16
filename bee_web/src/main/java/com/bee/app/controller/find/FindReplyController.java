package com.bee.app.controller.find;

import com.bee.client.params.find.FindReplyRequest;
import com.bee.commons.Codes;
import com.bee.modal.FindReplyItem;
import com.bee.pojo.find.Find;
import com.bee.pojo.find.FindReply;
import com.bee.pojo.shop.ShopComment;
import com.bee.services.find.IFindReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.BaseResponse;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/6/13.
 */
@RestController
@RequestMapping("/find/{fid}/reply")
public class FindReplyController {

    @Autowired
    private IFindReplyService findReplyService;

    /**
     *
     * @param fid
     * @param req
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PagingResult<FindReplyItem> getAppReplyList(@PathVariable Long fid, FindReplyRequest req) {
        req.setFindId(fid);
        return findReplyService.getAppReplyList(req);
    }

    /**
     *
     * @param fid
     * @param reply
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResponse save(@PathVariable Long fid, FindReply reply) {
        BaseResponse res = new BaseResponse();
        try {
            reply.setFind(new Find(fid));
            findReplyService.saveReply(reply);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            e.printStackTrace();
            res.setCode(Codes.Error);
        }
        return res;
    }

}
