package com.bee.dao.user;

import com.bee.commons.SQL;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/12/3.
 */
@Repository
public class MessageDao extends JpaDaoSupport<Message, Long> {

    /**
     * 获取用户未读消息
     *
     * @param param
     * @return
     */
    public List<Message> getNewMessage(MessageParam param) {
        return findByParams(SQL.User.Message.GetNewMessage, param.getUid(), param.getLastUpdateTime());
    }


}
