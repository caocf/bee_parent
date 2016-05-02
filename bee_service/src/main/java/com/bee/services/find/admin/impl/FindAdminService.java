package com.bee.services.find.admin.impl;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.find.Find;
import com.bee.services.find.admin.IFindAdminService;
import com.bee.services.find.impl.FindService;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 16/5/2.
 */
@Service
public class FindAdminService extends FindService implements IFindAdminService {

    /**
     * 查询发现列表
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<Find> queryFindList(AdminRequestPaging param) {
        return findDao.queryFindList(param);
    }
}
