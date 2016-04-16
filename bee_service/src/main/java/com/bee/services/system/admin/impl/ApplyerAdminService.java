package com.bee.services.system.admin.impl;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.Applyer;
import com.bee.services.system.admin.IApplyerAdminService;
import com.bee.services.system.impl.ApplyerService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 16/4/17.
 */
@Service
public class ApplyerAdminService extends ApplyerService implements IApplyerAdminService {

    /**
     * 查询商家申请
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<Applyer> queryApplyerList(AdminRequestPaging param) {
        return applyerDao.queryApplyerList(param);
    }
}
