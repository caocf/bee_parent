package com.bee.services.system;

import com.bee.pojo.AppVer;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
public interface IAppVerService {

    /**
     * 获取App版本列表
     *
     * @return
     */
    public List<AppVer> getAppVerList();

    /**
     * 发布APP版本
     *
     * @param appVer
     * @throws DataRunException
     */
    public void saveAppVer(AppVer appVer, MultipartFile file, HttpServletRequest req) throws DataRunException, IOException;
}
