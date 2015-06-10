package com.bee.services.find.impl;

import com.bee.client.params.find.FindListRequest;
import com.bee.dao.find.FindDao;
import com.bee.modal.FindListItem;
import com.bee.services.find.IFindService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/6/10.
 */
@Service
public class FindService implements IFindService {

    @Autowired
    private FindDao findDao;

    @Override
    public PagingResult<FindListItem> queryAppFindList(FindListRequest req) {
        return findDao.queryAppFindList(req);
    }
}
