package com.bee.services.find.impl;

import com.bee.dao.find.FindDao;
import com.bee.services.find.IFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public abstract class FindService implements IFindService {

    @Autowired
    public FindDao findDao;

}
