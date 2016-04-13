package com.bee.services.system.admin.impl;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Advice;
import com.bee.services.system.admin.IAdviceAdminService;
import com.bee.services.system.impl.AdviceService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 16/4/14.
 */
@Service
public class AdviceAdminService extends AdviceService implements IAdviceAdminService {

    /**
     * 查询用户建议
     *
     * @param params
     * @return
     */
    @Override
    public PagingResult<Advice> queryUserAdvice(AdminRequestPaging params) {
        return adviceDao.queryUserAdvice(params);
    }
}
