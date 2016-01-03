package com.bee.dao;

import com.bee.commons.SQL;
import com.bee.pojo.Area;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.bean.HQLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/21.
 */
@Repository
public class AreaDao extends JpaDaoSupport<Area, Long> {

    public List<Area> getAreaListById(Long id) {
        return findByParams(SQL.Area.queryAreaById, id);
    }

    public List<Area> getAreaByLastId(Long areaLastId) {
        System.out.println(areaLastId);
        return findByParams(SQL.Area.getAreaByLastId, areaLastId);
    }
}
