package com.bee.services.find;

import com.bee.pojo.find.Find;

/**
 * <b>发现业务接口</b>
 *
 * @since v1.1.0
 */
public interface IFindService {

    /**
     * 发布发现
     *
     * @param find 发现实体
     */
    void saveFind(Find find);
}
