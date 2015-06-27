package com.bee.services.system;

import com.bee.pojo.Applyer;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/6/27.
 */
public interface IApplyerService {

    /**
     *
     *
     * @param applyer
     * @throws DataRunException
     */
    public void addApplyer(Applyer applyer) throws DataRunException;

}
