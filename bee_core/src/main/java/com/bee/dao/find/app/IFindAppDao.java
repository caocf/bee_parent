package com.bee.dao.find.app;

import com.bee.dao.find.IFindDao;
import com.bee.domain.params.FindListParam;
import com.bee.modal.FindListItem;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IFindAppDao extends IFindDao {


    PagingResult<FindListItem> queryFindList(FindListParam param);

}
