package com.bee.services.system.admin;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Advice;
import com.bee.services.system.IAdviceService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 16/4/14.
 */
public interface IAdviceAdminService extends IAdviceService {

    /**
     * 查询用户建议
     *
     * @param params
     * @return
     */
    PagingResult<Advice> queryUserAdvice(AdminRequestPaging params);

}
