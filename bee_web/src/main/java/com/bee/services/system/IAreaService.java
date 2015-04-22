package com.bee.services.system;

import com.bee.pojo.Area;

import java.util.List;

/**
 * Created by suntongwei on 15/4/21.
 */
public interface IAreaService {

    /**
     * 根据ID查询地区
     *
     * @param id
     * @return
     */
    public List<Area> getAreaListById(long id);
}
