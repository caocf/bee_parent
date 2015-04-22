package com.bee.services.system.impl;

import com.bee.dao.AreaDao;
import com.bee.pojo.Area;
import com.bee.services.system.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 15/4/21.
 */
@Service
public class AreaService implements IAreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaListById(long id) {
        return areaDao.getAreaListById(id);
    }
}
