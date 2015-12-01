package com.bee.services.find.impl;

import com.bee.dao.find.FindReplyDao;
import com.bee.services.find.IFindReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/12/1.
 */
@Service
public abstract class FindReplyService implements IFindReplyService {

    @Autowired
    protected FindReplyDao findReplyDao;

}
