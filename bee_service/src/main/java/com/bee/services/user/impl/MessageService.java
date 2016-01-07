package com.bee.services.user.impl;

import com.bee.dao.user.MessageDao;
import com.bee.services.user.IMessageService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/12/3.
 */
public abstract class MessageService implements IMessageService {

    @Autowired
    protected MessageDao messageDao;

    /**
     * 删除用户消息
     *
     * @param messageIds
     */
    @Override
    @Transactional
    public void deleteMessages(Long[] messageIds) throws DataRunException {
        messageDao.deleteByIds(messageIds);
    }


}
