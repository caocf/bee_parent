package com.bee.services.system.impl;

import com.bee.dao.ApplyerDao;
import com.bee.pojo.Applyer;
import com.bee.services.system.IApplyerService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/6/27.
 */
@Service
public class ApplyerService implements IApplyerService {

    @Autowired
    private ApplyerDao applyerDao;

    @Override
    @Transactional
    public void addApplyer(Applyer applyer) throws DataRunException {
        applyer.setCreateTime(System.currentTimeMillis());
        applyerDao.save(applyer);
    }
}
