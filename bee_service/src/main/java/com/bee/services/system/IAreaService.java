package com.bee.services.system;

import com.bee.pojo.Area;

import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IAreaService {

    /**
     * 根据ID查询地区
     *
     * @param id
     * @return
     */
    List<Area> getAreaListById(long id);

    /**
     * 根据参数查询地区
     *
     * @return
     */
    List<Area> getAreaListAll();

    /**
     * 获取大于该主键的记录
     *
     * @param areaLastId
     * @return
     */
    List<Area> getAreaByLastId(long areaLastId);
}
