package com.bee.dao.user;

import com.bee.commons.SQL;
import com.bee.domain.modal.app.user.MessageList;
import com.bee.domain.params.user.MessageParam;
import com.bee.pojo.user.Message;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/12/3.
 */
@Repository
public class MessageDao extends JpaDaoSupport<Message, Long> {




}
