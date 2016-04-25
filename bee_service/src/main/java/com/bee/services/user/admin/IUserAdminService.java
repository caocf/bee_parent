package com.bee.services.user.admin;

import com.bee.client.params.user.AdminUserListRequest;
import com.bee.pojo.user.User;
import com.bee.services.user.IUserService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IUserAdminService extends IUserService {

    /**
     * 根据参数查询用户列表
     *
     * @param req
     * @return
     */
    PagingResult<User> queryUserListByParams(AdminUserListRequest req);

}
