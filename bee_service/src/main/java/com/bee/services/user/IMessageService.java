package com.bee.services.user;

import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/12/3.
 */
public interface IMessageService {


    /**
     * 删除指定用户所有消息
     *
     * @param messageIds
     */
    void deleteMessages(Long[] messageIds) throws DataRunException;


}
