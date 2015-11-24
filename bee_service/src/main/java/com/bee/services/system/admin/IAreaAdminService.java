package com.bee.services.system.admin;

import com.bee.pojo.Area;
import com.bee.services.system.IAreaService;
import com.qsd.framework.hibernate.exception.DataRunException;

/**
 * Created by suntongwei on 15/11/15.
 */
public interface IAreaAdminService extends IAreaService {

    /**
     * 保存地区
     *
     * @param area
     * @throws com.qsd.framework.hibernate.exception.DataRunException
     */
    void addArea(Area area) throws DataRunException;

    /**
     * 获取单个地区
     *
     * @param id
     * @return
     */
    Area getAreaById(long id);

    /**
     * 更新地区
     *
     * @param area
     * @throws DataRunException
     */
    void updateArea(Area area) throws DataRunException;
}
