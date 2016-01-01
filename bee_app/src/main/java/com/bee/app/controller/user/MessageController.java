package com.bee.app.controller.user;

import com.bee.commons.Codes;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.bee.services.user.app.IMessageAppService;
import com.qsd.framework.domain.response.ResponseArray;
import com.qsd.framework.domain.response.ResponsePaging;
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
}
