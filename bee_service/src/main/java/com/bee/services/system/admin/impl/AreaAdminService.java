package com.bee.services.system.admin.impl;

import com.bee.pojo.Area;
import com.bee.services.system.admin.IAreaAdminService;
import com.bee.services.system.impl.AreaService;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class AreaAdminService extends AreaService implements IAreaAdminService {

    @Override
    @Transactional
    public void addArea(Area area) throws DataRunException {
        areaDao.save(area);
    }

    @Override
    public Area getAreaById(long id) {
        return areaDao.findById(id);
    }

    @Override
    @Transactional
    public void updateArea(Area area) throws DataRunException {
        areaDao.update(area);
    }
}
