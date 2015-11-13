package com.bee.services.system;

import com.bee.pojo.Area;
import com.qsd.framework.hibernate.exception.DataRunException;

import java.util.List;

/**
 * Created by suntongwei on 15/4/21.
 */
public interface IAreaService {

    List<Area> getAreaListById(long id);
}
