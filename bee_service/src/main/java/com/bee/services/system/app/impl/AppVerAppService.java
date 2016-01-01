package com.bee.services.system.app.impl;

import com.bee.commons.Consts;
import com.bee.pojo.AppVer;
import com.bee.services.system.app.IAppVerAppService;
import com.bee.services.system.impl.AppVerService;
import org.springframework.stereotype.Service;

/**
 * Created by suntongwei on 15/12/25.
 */
@Service
public class AppVerAppService extends AppVerService implements IAppVerAppService {

    @Override
    public AppVer getNewAppVer() {
        return appVerDao.getNewAppVer(Consts.AppType.Android);
    }
}
