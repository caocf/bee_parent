package com.bee.services.find;

import com.bee.domain.params.find.FindSaveParam;
import com.bee.pojo.find.Find;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * <b>发现业务接口</b>
 *
 * @since v1.1.0
 */
public interface IFindService {

    /**
     * 发布发现
     *
     * @param param
     */
    void saveFind(FindSaveParam param) throws DataRunException;
}
