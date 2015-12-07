package com.bee.services.user.impl;

import com.bee.dao.user.MessageDao;
import com.bee.services.user.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/12/3.
 */
@Service
public abstract class MessageService implements IMessageService {

    @Autowired
    protected MessageDao messageDao;

}
