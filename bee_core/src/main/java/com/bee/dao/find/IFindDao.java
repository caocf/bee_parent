package com.bee.dao.find;

import com.bee.client.params.find.FindListRequest;
import com.bee.modal.FindListItem;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IFindDao {


    public PagingResult<FindListItem> queryAppFindList(FindListRequest req);
}
