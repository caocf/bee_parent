package com.bee.services.system.impl;

import com.bee.dao.ApplyerDao;
import com.bee.services.system.IApplyerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 16/4/17.
 */
public abstract class ApplyerService implements IApplyerService {

    @Autowired
    protected ApplyerDao applyerDao;

}
