package com.bee.services.find.busi;

import com.bee.domain.params.find.FindSaveParam;
import com.bee.services.find.IFindService;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/25.
 */
public interface IFindBusiService extends IFindService {

    /**
     * 发布发现
     *
     * @param find
     */
    void saveFind(FindSaveParam find) throws DataRunException;
}
