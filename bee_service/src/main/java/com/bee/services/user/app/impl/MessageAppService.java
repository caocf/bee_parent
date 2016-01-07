package com.bee.services.user.app.impl;

import com.bee.dao.user.app.MessageAppDao;
import com.bee.domain.modal.app.user.MessageList;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.bee.services.user.app.IMessageAppService;
import com.bee.services.user.impl.MessageService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 16/1/1.
 */
@Service
public class MessageAppService extends MessageService implements IMessageAppService {

    @Autowired
    private MessageAppDao messageAppDao;

    /**
     * 获取用户未读消息
     *
     * @param param
     * @return
     */
    @Override
    public List<MessageList> getUserMessage(MessageParam param) {
        return messageAppDao.getUserMessage(param);
    }

    @Override
    @Transactional
    public void deleteMessageByUser(Long userId) throws DataRunException {
        messageAppDao.deleteMessageByUser(userId);
    }

    /**
     * 更新消息
     *
     * @param message
     * @throws DataRunException
     */
    @Override
    public void updateMessage(Message message) throws DataRunException {

    }

    /**
     * 获取消息
     *
     * @param mid
     * @return
     */
    @Override
    public Message getMessageById(Long mid) {
        return messageDao.findById(mid);
    }
}
