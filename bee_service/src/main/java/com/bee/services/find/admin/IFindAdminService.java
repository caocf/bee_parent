package com.bee.services.find.admin;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.find.Find;
import com.bee.services.find.IFindService;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 16/5/2.
 */
public interface IFindAdminService extends IFindService {


    /**
     * 查询发现列表
     *
     * @param param
     * @return
     */
    PagingResult<Find> queryFindList(AdminRequestPaging param);


}
