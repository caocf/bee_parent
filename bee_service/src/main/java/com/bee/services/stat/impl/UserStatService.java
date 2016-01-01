package com.bee.services.stat.impl;

import com.bee.dao.stat.UserLoginStatDao;
import com.bee.services.stat.IUserStatService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class UserStatService implements IUserStatService {

    @Autowired
    protected UserLoginStatDao userLoginStatDao;
}
