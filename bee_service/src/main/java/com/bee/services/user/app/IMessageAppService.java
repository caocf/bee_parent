package com.bee.services.user.app;

import com.bee.domain.modal.app.user.MessageList;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.bee.services.user.IMessageService;
import com.qsd.framework.hibernate.exception.DataRunException;

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
    List<MessageList> getUserMessage(MessageParam param);

    /**
     * 根据用户删除所有消息
     *
     * @param userId
     */
    void deleteMessageByUser(Long userId) throws DataRunException;

    /**
     * 更新消息
     *
     * @param message
     * @throws DataRunException
     */
    void updateMessage(Message message) throws DataRunException;

    /**
     * 根据主键获取消息
     *
     * @return
     */
    Message getMessageById(Long mid);
}
