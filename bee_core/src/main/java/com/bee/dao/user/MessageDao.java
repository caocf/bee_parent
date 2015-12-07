package com.bee.dao.user;

import com.bee.pojo.user.Message;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/12/3.
 */
@Repository
public class MessageDao extends JpaDaoSupport<Message, Long> {
}
