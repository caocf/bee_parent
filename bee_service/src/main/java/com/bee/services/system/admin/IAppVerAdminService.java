package com.bee.services.system.admin;

import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.AppVer;
import com.bee.services.system.IAppVerService;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by suntongwei on 16/4/24.
 */
public interface IAppVerAdminService extends IAppVerService {

    /**
     * 查询版本列表
     *
     * @param params
     * @return
     */
    PagingResult<AppVer> queryAppVerList(AdminRequestPaging params);

    /**
     * 发布App
     *
     * @param appVer
     * @param file
     * @param request
     * @throws DataRunException
     */
    void saveAppVer(AppVer appVer, MultipartFile file, HttpServletRequest request) throws DataRunException;
}
