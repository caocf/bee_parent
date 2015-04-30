package com.bee.dao.shop;

import com.bee.commons.SQL;
import com.bee.pojo.shop.ShopFocus;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/4/30.
 */
@Repository
public class ShopFocusDao extends JpaDaoSupport<ShopFocus, Long> {

    public List<ShopFocus> getFocusList(long sid) {
        return findByParams(SQL.Shop.Focus.getFocusList, sid);
    }
}
