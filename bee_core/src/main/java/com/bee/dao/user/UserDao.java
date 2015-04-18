package com.bee.dao.user;

import com.bee.commons.SQL;
import com.bee.pojo.user.User;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/4/16.
 */
@Repository
public class UserDao extends JpaDaoSupport<User, Long> {

    public User getUserByAccount(String account) {
        return findFirstByParams(SQL.User.queryUserByAccount, account);
    }
}
