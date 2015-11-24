package com.bee.services.find.app;

import com.bee.domain.modal.app.find.Find;
import com.bee.domain.params.find.FindListParam;
import com.bee.modal.FindListItem;
import com.bee.services.find.IFindService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IFindAppService extends IFindService {

    /**
     * <b>查询发现列表</b>
     * @see com.bee.modal.FindListItem
     *
     * @param param 查询参数
     * @return PagingResult<Find>
     */
    PagingResult<Find> queryFindList(FindListParam param);

}
