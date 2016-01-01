package com.bee.services.user.app.impl;

import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.bee.services.user.app.IMessageAppService;
import com.bee.services.user.impl.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 16/1/1.
 */
@Service
public class MessageAppService extends MessageService implements IMessageAppService {

    /**
     * 获取用户未读消息
     *
     * @param param
     * @return
     */
    @Override
    public List<Message> getNewMessage(MessageParam param) {
        return messageDao.getNewMessage(param);
    }
}
