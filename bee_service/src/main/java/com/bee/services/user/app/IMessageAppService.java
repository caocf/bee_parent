package com.bee.services.user.app;

import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.bee.services.user.IMessageService;

import java.util.List;

/**
 * Created by suntongwei on 16/1/1.
 */
public interface IMessageAppService extends IMessageService {


    /**
     * 获取用户新消息
     *
     * @param param
     * @return
     */
    List<Message> getNewMessage(MessageParam param);

}
