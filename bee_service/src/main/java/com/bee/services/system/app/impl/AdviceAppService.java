package com.bee.services.system.app.impl;

import com.bee.pojo.Advice;
import com.bee.services.system.app.IAdviceAppService;
import com.bee.services.system.impl.AdviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/12/21.
 */
@Service
public class AdviceAppService extends AdviceService implements IAdviceAppService {

    /**
     * 提交建议
     *
     * @param advice
     */
    @Override
    @Transactional
    public void addAdvice(Advice advice) {
        advice.setCreateTime(System.currentTimeMillis());
        adviceDao.save(advice);
    }
}
