package com.bee.services.system.impl;

import com.bee.dao.AppVerDao;
import com.bee.services.system.IAppVerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class AppVerService implements IAppVerService {

    @Autowired
    protected AppVerDao appVerDao;

}
