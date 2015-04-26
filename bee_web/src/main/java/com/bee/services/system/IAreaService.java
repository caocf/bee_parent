package com.bee.services.system;

import com.bee.pojo.Area;
import com.qsd.framework.hibernate.exception.DataRunException;

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

    /**
     * 根据参数查询地区
     *
     * @return
     */
    public List<Area> getAreaListAll();

    /**
     * 保存地区
     *
     * @param area
     * @throws DataRunException
     */
    public void addArea(Area area) throws DataRunException;

    /**
     * 获取单个地区
     *
     * @param id
     * @return
     */
    public Area getAreaById(long id);

    /**
     * 更新地区
     *
     * @param area
     * @throws DataRunException
     */
    public void updateArea(Area area) throws DataRunException;
}
