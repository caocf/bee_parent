package com.bee.services.system;

import com.bee.pojo.Advice;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/6/24.
 */
public interface IAdviceService {


    public void saveAdvice(Advice advice) throws DataRunException;

}
