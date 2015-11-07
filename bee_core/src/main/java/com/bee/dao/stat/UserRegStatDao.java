package com.bee.dao.stat;

import com.bee.commons.SQL;
import com.bee.pojo.stat.UserRegStat;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suntongwei on 15/5/7.
 */
@Repository
public class UserRegStatDao extends JpaDaoSupport<UserRegStat, Long> {

    /**
     * 统计过去30天用户注册量
     *
     * @return
     */
    @Deprecated
    public List<UserRegStat> statDayRegStat() {
//        return findConverByParams(SQL.Stat.User.statUserRegStat, new QueryDataConver<UserRegStat>() {
//            @Override
//            public UserRegStat converData(Object[] obj) {
//                UserRegStat item = new UserRegStat();
//                item.setYear(NumberUtil.parseInteger(obj[0],0));
//                item.setMonth(NumberUtil.parseInteger(obj[1],0));
//                item.setDay(NumberUtil.parseInteger(obj[2],0));
//                item.setNum(NumberUtil.parseInteger(obj[3],0));
//                return item;
//            }
//        });
        return null;
    }

}
