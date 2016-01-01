package com.bee.services.system.impl;

import com.bee.dao.AdviceDao;
import com.bee.services.system.IAdviceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by suntongwei on 15/12/21.
 */
public abstract class AdviceService implements IAdviceService {

    @Autowired
    protected AdviceDao adviceDao;
}
