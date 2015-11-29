package com.bee.services.find.app;

import com.bee.domain.modal.app.find.FindListItem;
import com.bee.domain.params.find.FindListParam;
import com.bee.services.find.IFindService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IFindAppService extends IFindService {

    /**
     * <b>查询发现列表</b>
     *
     * @param param 查询参数
     * @return PagingResult<Find>
     */
    PagingResult<FindListItem> queryFindList(FindListParam param);

}
