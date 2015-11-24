package com.bee.dao.shop.app;

import com.bee.commons.SQL;
import com.bee.dao.shop.ShopAttendDao;
import com.bee.domain.modal.app.shop.ShopAttend;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/11/22.
 */
@Repository
public class ShopAttendAppDao extends ShopAttendDao {

    /**
     *【C端】查询商家出勤表
     *
     * @param sid
     * @return
     */
    public List<ShopAttend> getShopAttendByShopId(long sid, long attendTime) {
        return findConverByParams(SQL.Shop.Attend.GetShopAttendByShopIdForApp,
                new QueryDataConver<ShopAttend>() {
                    @Override
                    public ShopAttend converData(Object[] objects) {
                        ShopAttend item = new ShopAttend();
                        item.setTecheeNumber(StringUtil.parseString(objects[0], ""));
                        item.setGroupName(StringUtil.parseString(objects[1], ""));
                        return item;
                    }
                }, sid, attendTime);
    }

}
