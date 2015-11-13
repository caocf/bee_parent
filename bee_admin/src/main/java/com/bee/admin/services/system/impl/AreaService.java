package com.bee.admin.services.system.impl;

import com.bee.admin.services.system.IAreaService;
import com.bee.dao.AreaDao;
import com.bee.pojo.Area;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/11/8.
 */
@Service
public class AreaService implements IAreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaListById(long id) {
        return areaDao.getAreaListById(id);
    }

    @Override
    public List<Area> getAreaListAll() {
        return areaDao.findAll();
    }

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
