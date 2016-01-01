package com.bee.app.controller.user;

import com.bee.commons.Codes;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.bee.services.user.app.IMessageAppService;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.domain.response.Response;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.domain.response.ResponsePaging;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suntongwei on 15/12/3.
 */
@RestController
@RequestMapping("/v1/user/{userId}/message")
public class MessageController {

    @Autowired
    private IMessageAppService messageAppService;

    /**
     * 获取新消息
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseArray<Message> getNewMessage(@PathVariable Long userId, MessageParam param) {
        ResponseArray<Message> res = new ResponseArray<>();
        param.setUid(userId);
        res.setResult(messageAppService.getNewMessage(param));
        res.setCode(Codes.Success);
        return res;
    }

    /**
     * 用户删除消息
     *
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public Response deleteMessage(@PathVariable Long userId, String messageIds) {
        Response res = new Response();
        if (StringUtil.isNull(messageIds) || null == userId || userId < 1) {
            res.setCode(Codes.ParamsError);
            res.setMsg("请选择删除的信息");
            return res;
        }
        String[] ids = messageIds.split(",");
        Long[] afterIds = new Long[ids.length];
        try {
            for (int i = 0; i < ids.length; i++) {
                afterIds[i] = Long.valueOf(ids[i]);
            }
            messageAppService.deleteMessages(afterIds);
            res.setCode(Codes.Success);
        } catch (DataRunException e) {
            res.setCode(Codes.Error);
            res.setMsg("删除失败,请重试");
        } catch (NumberFormatException e) {
            res.setCode(Codes.ParamsError);
            res.setMsg("请选择删除的信息");
        }
        return res;
    }


}
