package com.bee.services.system;

import com.bee.pojo.Advice;

/**
 * Created by suntongwei on 15/12/21.
 */
public interface IAdviceService {

    /**
     * 提交建议
     *
     * @param advice
     */
    void addAdvice(Advice advice);

}
