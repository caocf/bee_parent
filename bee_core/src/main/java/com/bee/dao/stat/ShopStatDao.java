package com.bee.dao.stat;

import com.bee.domain.modal.admin.stat.ShopCountStat;
import com.bee.pojo.stat.ShopStat;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suntongwei on 16/5/4.
 */
@Repository
public class ShopStatDao extends JpaDaoSupport<ShopStat, Long> {

    public static final String StatShopVisitCount = "SELECT " +
            "B.`NAME`, COUNT(*) AS SC " +
            "FROM TB_SHOP_STAT A " +
            "LEFT OUTER JOIN " +
            "TB_SHOP B " +
            "ON A.SHOP = B.SID " +
            "LEFT OUTER JOIN " +
            "TB_USER C " +
            "ON A.USER = C.UID " +
            "WHERE A.CREATETIME >= ? " +
            "GROUP BY B.`NAME` " +
            "ORDER BY SC ASC";

    /**
     *
     *
     * @return
     */
    public List<ShopCountStat> statShopVisitCount(long startTime) {
        return findConverByParams(StatShopVisitCount, StatShopVisitCountConver, startTime);
    }
    private static final QueryDataConver<ShopCountStat> StatShopVisitCountConver = new QueryDataConver<ShopCountStat>() {
        @Override
        public ShopCountStat converData(Object[] row) {
            ShopCountStat item = new ShopCountStat();
            item.setName(StringUtil.parseString(row[0], ""));
            item.setCount(NumberUtil.parseDouble(row[1], 0));
            return item;
        }
    };

    // MateShopStat
    public static final String MateShopStat = "DELETE FROM TB_SHOP_STAT A WHERE A.CREATETIME < ?";

    /**
     *
     * @throws DataRunException
     */
    public void mateShopStat(long time) throws DataRunException {
        execute(MateShopStat, time);
    }

}
