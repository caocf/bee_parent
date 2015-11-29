package com.bee.services.find;

import com.bee.client.params.find.FindListRequest;
import com.bee.domain.modal.app.find.FindListItem;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/6/10.
 */
public interface IFindService {

    /**
     *
     * @param req
     * @return
     */
    PagingResult<FindListItem> queryAppFindList(FindListRequest req);

}
