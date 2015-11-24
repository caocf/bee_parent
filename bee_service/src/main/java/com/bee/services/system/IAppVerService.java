package com.bee.services.system;

import com.bee.pojo.AppVer;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IAppVerService {

    /**
     * 根据类型返回最新版本
     * 该方法由子类实现
     *
     * @return
     */
    AppVer getNewAppVer();

}
