package com.bee.services.system.busi.impl;

import com.bee.commons.Consts;
import com.bee.pojo.AppVer;
import com.bee.services.system.busi.IAppVerBusiService;
import com.bee.services.system.impl.AppVerService;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class AppVerBusiService extends AppVerService implements IAppVerBusiService {

    /**
     * 获取最新版本号
     *
     * @return
     */
    @Override
    public AppVer getNewAppVer() {
        return appVerDao.getNewAppVer(Consts.AppType.AndroidForBusi);
    }
}
