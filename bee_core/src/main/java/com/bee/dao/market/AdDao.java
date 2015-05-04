package com.bee.dao.market;

import com.bee.commons.SQL;
import com.bee.pojo.market.Ad;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/5/4.
 */
@Repository
public class AdDao extends JpaDaoSupport<Ad, Long> {

    public List<Ad> getAdList() {
        return find(SQL.Market.Ad.getAdList);
    }
}
