package com.bee.services.system.impl;

import com.bee.commons.Consts;
import com.bee.dao.AppVerDao;
import com.bee.pojo.AppVer;
import com.bee.services.system.IAppVerService;
import com.qsd.framework.commons.utils.FileUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@Service
public class AppVerService implements IAppVerService {

    @Autowired
    private AppVerDao appVerDao;

    @Override
    public List<AppVer> getAppVerList() {
        return appVerDao.getAppVerList();
    }

    @Override
    @Transactional
    public void saveAppVer(AppVer appVer, MultipartFile file, HttpServletRequest req) throws DataRunException, IOException {
        String fileName = "";
        try {
            String uploadFileName = file.getOriginalFilename();
            String p = File.separator + "app";
            String path = req.getSession().getServletContext().getRealPath(p);
            fileName = File.separator +
                    (appVer.getType() == Consts.AppType.Android ? "android_" : "ios_") +
                    appVer.getVerStr() + "_" + appVer.getVer() +
                    uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
            FileUtil.copy(file.getInputStream(), new File(path + fileName));
        } catch(IOException e) {
            throw e;
        }
        try {
            appVer.setPath(Consts.BaseUrl + File.separator + "app" + fileName);
            appVer.setCreateTime(System.currentTimeMillis());
            appVerDao.save(appVer);
        } catch (DataRunException e) {
            throw e;
        }
    }
}
