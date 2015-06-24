package com.bee.services.system.impl;

import com.bee.dao.AdviceDao;
import com.bee.pojo.Advice;
import com.bee.services.system.IAdviceService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/6/24.
 */
@Service
public class AdviceService implements IAdviceService {

    @Autowired
    private AdviceDao adviceDao;

    @Override
    @Transactional
    public void saveAdvice(Advice advice) throws DataRunException {
        advice.setCreateTime(System.currentTimeMillis());
        adviceDao.save(advice);
    }
}
