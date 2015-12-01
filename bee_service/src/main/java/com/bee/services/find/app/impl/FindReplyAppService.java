package com.bee.services.find.app.impl;

import com.bee.dao.find.app.FindReplyAppDao;
import com.bee.domain.modal.app.find.FindReplyItem;
import com.bee.domain.params.find.FindReplyParam;
import com.bee.pojo.find.FindReply;
import com.bee.services.find.app.IFindReplyAppService;
import com.bee.services.find.impl.FindReplyService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/12/1.
 */
@Service
public class FindReplyAppService extends FindReplyService implements IFindReplyAppService {

    @Autowired
    private FindReplyAppDao findReplyAppDao;

    /**
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<FindReplyItem> getFindReplyForApp(FindReplyParam param) {
        return findReplyAppDao.getReplyListForApp(param);
    }

    /**
     *
     * @param findReply
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void save(FindReply findReply) throws DataRunException {
        findReply.setCreateTime(System.currentTimeMillis());
        findReplyDao.save(findReply);
    }
}
