package com.bee.services.find;

import com.bee.domain.modal.app.find.FindReplyItem;
import com.bee.domain.params.find.FindReplyParam;
import com.bee.pojo.find.FindReply;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/6/13.
 */
public interface IFindReplyService {

    /**
     *
     * @param req
     * @return
     */
    public PagingResult<FindReplyItem> getAppReplyList(FindReplyParam req);

    /**
     *
     * @param findReply
     * @throws DataRunException
     */
    public void saveReply(FindReply findReply) throws DataRunException;
}
