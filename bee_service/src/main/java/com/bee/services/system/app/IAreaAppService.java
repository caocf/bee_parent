package com.bee.services.system.app;

import com.bee.pojo.Area;
import com.bee.services.system.IAreaService;

import java.util.List;

/**
 * Created by suntongwei on 16/1/2.
 */
public interface IAreaAppService extends IAreaService {

    /**
     * 获取大于该主键的记录
     *
     * @param areaLastId
     * @return
     */
    List<Area> getAreaByLastId(Long areaLastId);
}
