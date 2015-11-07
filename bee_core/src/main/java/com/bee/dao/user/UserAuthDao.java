package com.bee.dao.user;

import com.bee.pojo.user.UserAuth;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/11/7.
 */
@Repository
public class UserAuthDao extends JpaDaoSupport<UserAuth, Long> {
}
