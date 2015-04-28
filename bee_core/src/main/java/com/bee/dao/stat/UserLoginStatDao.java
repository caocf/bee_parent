package com.bee.dao.stat;

import com.bee.pojo.stat.UserLoginStat;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/4/28.
 */
@Repository
public class UserLoginStatDao extends JpaDaoSupport<UserLoginStat, Long> {
}
