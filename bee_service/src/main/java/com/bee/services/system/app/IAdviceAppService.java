package com.bee.services.system.app;

import com.bee.pojo.Advice;
import com.bee.services.system.IAdviceService;

/**
 * Created by suntongwei on 15/12/21.
 */
public interface IAdviceAppService extends IAdviceService {


    /**
     * 提交建议
     *
     * @param advice
     */
    void addAdvice(Advice advice);

}
