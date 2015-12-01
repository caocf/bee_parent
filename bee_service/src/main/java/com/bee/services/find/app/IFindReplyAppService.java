package com.bee.services.find.app;

import com.bee.domain.modal.app.find.FindReplyItem;
import com.bee.domain.params.find.FindReplyParam;
import com.bee.services.find.IFindReplyService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/12/1.
 */
public interface IFindReplyAppService extends IFindReplyService {

    /**
     *
     * @param param
     * @return
     */
    PagingResult<FindReplyItem> getFindReplyForApp(FindReplyParam param);

}
