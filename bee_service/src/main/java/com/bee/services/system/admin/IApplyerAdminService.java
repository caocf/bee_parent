package com.bee.services.system.admin;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Applyer;
import com.bee.services.system.IApplyerService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 16/4/17.
 */
public interface IApplyerAdminService extends IApplyerService {

    /**
     * 查询商家申请
     *
     * @param param
     * @return
     */
    PagingResult<Applyer> queryApplyerList(AdminRequestPaging param);

}
