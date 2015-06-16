package com.bee.services.find.impl;

import com.bee.client.params.find.FindReplyRequest;
import com.bee.dao.find.FindReplyDao;
import com.bee.modal.FindReplyItem;
import com.bee.pojo.find.FindReply;
import com.bee.services.find.IFindReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/6/13.
 */
@Service
public class FindReplyService implements IFindReplyService {

    @Autowired
    private FindReplyDao findReplyDao;

    /**
     *
     * @param req
     * @return
     */
    public PagingResult<FindReplyItem> getAppReplyList(FindReplyRequest req) {
        return findReplyDao.getAppReplyList(req);
    }

    /**
     *
     * @param findReply
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void saveReply(FindReply findReply) throws DataRunException {
        findReply.setCreateTime(System.currentTimeMillis());
        findReplyDao.save(findReply);
    }
}
