package com.bee.services.system.impl;

import com.bee.dao.AreaDao;
import com.bee.pojo.Area;
import com.bee.services.system.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public abstract class AreaService implements IAreaService {

    @Autowired
    protected AreaDao areaDao;

    @Override
    public List<Area> getAreaListById(long id) {
        return areaDao.getAreaListById(id);
    }

    @Override
    public List<Area> getAreaListAll() {
        return areaDao.findAll();
    }
}
