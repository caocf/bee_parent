package com.bee.services.system.app.impl;

import com.bee.pojo.Area;
import com.bee.services.system.app.IAreaAppService;
import com.bee.services.system.impl.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suntongwei on 16/1/2.
 */
@Service
public class AreaAppService extends AreaService implements IAreaAppService {

    @Override
    public List<Area> getAreaByLastId(Long areaLastId) {
        return areaDao.getAreaByLastId(areaLastId);
    }
}
