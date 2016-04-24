package com.bee.services.system.admin.impl;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.domain.params.AdminRequestPaging;
import com.bee.pojo.AppVer;
import com.bee.services.system.admin.IAppVerAdminService;
import com.bee.services.system.impl.AppVerService;
import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

/**
 * Created by suntongwei on 16/4/24.
 */
@Service
public class AppVerAdminService extends AppVerService implements IAppVerAdminService {


    /**
     * 查询版本列表
     *
     * @param params
     * @return
     */
    @Override
    public PagingResult<AppVer> queryAppVerList(AdminRequestPaging params) {
        return appVerDao.queryAppVerList(params);
    }

    /**
     * 发布App
     *
     * @param appVer
     * @param file
     * @param request
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void saveAppVer(AppVer appVer, MultipartFile file, HttpServletRequest request) throws DataRunException {
        String path;
        String type = appVer.getType() == Consts.AndroidForBusi ? "_busi" : "";
        // android_v1.0.0_1.apk, android_busi_v1.0.0_1.apk
        String fileName =  "android" + type + "_" + appVer.getVerStr() + "_" + appVer.getVer() + ".apk";
        if (!Consts.isDebug) {
            path = Consts.RemoteAppDownloadPath + File.separator + fileName;
        } else {
            path = request.getSession().getServletContext().getRealPath("app" + File.separator + fileName);
        }
        try {
            FileUtil.copy(file.getInputStream(), new File(path));
            appVer.setCreateTime(System.currentTimeMillis());
            appVer.setPath(path);
            appVer.setUrl(Consts.getBaseUrl() + File.separator + "s" +
                    File.separator + "app" + File.separator + fileName);
            appVerDao.save(appVer);
        } catch (IOException e) {
            throw new DataRunException(Codes.ParamsError, "文件错误");
        } catch (DataRunException de) {
            throw de;
        }
    }

    @Override
    public AppVer getNewAppVer() {
        return null;
    }


}
