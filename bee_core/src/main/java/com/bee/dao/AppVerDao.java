package com.bee.dao;

import com.bee.commons.SQL;
import com.bee.pojo.AppVer;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@Repository
public class AppVerDao extends JpaDaoSupport<AppVer, Long> {

    public List<AppVer> getAppVerList() {
        return findByParams(SQL.AppVer.getAppVerList);
    }
}
