package com.bee.services.find;

import com.bee.client.params.find.FindReplyRequest;
import com.bee.modal.FindReplyItem;
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
    public PagingResult<FindReplyItem> getAppReplyList(FindReplyRequest req);

    /**
     *
     * @param findReply
     * @throws DataRunException
     */
    public void saveReply(FindReply findReply) throws DataRunException;
}
