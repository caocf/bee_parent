package com.bee.services.stat.admin.impl;

import com.bee.admin.params.stat.QueryUserLoginStatParam;
import com.bee.admin.params.user.QueryUserParam;
import com.bee.commons.Consts;
import com.bee.dao.stat.UserLoginStatDao;
import com.bee.dao.user.UserDao;
import com.bee.pojo.stat.UserLoginStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.admin.IUserStatAdminService;
import com.bee.services.stat.impl.UserStatService;
import com.qsd.framework.commons.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by suntongwei on 15/11/15.
 */
@Service
public class UserStatAdminService extends UserStatService implements IUserStatAdminService {

    @Autowired
    private UserLoginStatDao userLoginStatDao;
    @Autowired
    private UserDao userDao;

    /**
     * 统计过去number天用户登录数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    @Override
    public Double[] statUserLogin(int number, long time) {

        /**
         * 组装数据
         */
        Double[] result = new Double[number];

        /**
         * 查询时间，按照 粒度 * 时间粒度
         */
        Calendar today = Calendar.getInstance();
        // 时间+1，为了包含今天
        today.add(Calendar.DAY_OF_MONTH, 1);
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        today.set(Calendar.MILLISECOND, 999);
        long queryTime = today.getTimeInMillis() - (time * number); // 这里减1是为了包含今天

        // 组装参数
        QueryUserLoginStatParam param = new QueryUserLoginStatParam();
        param.setStartCreateTime(queryTime);
        param.setSortSection("A.ulsId ASC");

        // 进行查询
        List<UserLoginStat> userLoginStats = userLoginStatDao.queryUserLoginStatByParam(param);

        // 统计时间
        long statTime = 0l;

        /**
         * 遍历组装数据
         */
        for (int i = 0; i < number; i++) {

            // 记录统计数量
            double count = 0d;
            /**
             * 按天计算
             */
            statTime = queryTime + (i * time);

            /**
             * 把统计结果放入集合
             * 每统计一个，从集合中删除
             */
            while (userLoginStats.size() > 0) {
                if (userLoginStats.get(0).getCreateTime() > statTime) {
                    break;
                }
                userLoginStats.remove(0);
                count++;
            }
            result[i] = count;
        }

        return result;
    }

    /**
     * 统计设备号数据
     *
     * @param number
     * @param time
     * @return
     */
    @Override
    public Double[] statUserDeviceStat(int number, long time) {
        /**
         * 组装数据
         */
        Double[] result = new Double[number];

        /**
         * 查询时间，按照 粒度 * 时间粒度
         */
        Calendar today = Calendar.getInstance();
        // 时间+1，为了包含今天
        today.add(Calendar.DAY_OF_MONTH, 1);
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        today.set(Calendar.MILLISECOND, 999);
        long queryTime = today.getTimeInMillis() - (time * number); // 这里减1是为了包含今天

        // 组装参数
        QueryUserLoginStatParam param = new QueryUserLoginStatParam();
        param.setStartCreateTime(queryTime);
        param.setGroupBy("A.device");
        param.setSortSection("A.ulsId ASC");

        // 进行查询
        List<UserLoginStat> userDeviceStats = userLoginStatDao.queryUserLoginStatByParam(param);

        // 统计时间
        long statTime = 0l;

        /**
         * 遍历组装数据
         */
        for (int i = 0; i < number; i++) {

            // 记录统计数量
            double count = 0d;
            /**
             * 按天计算
             */
            statTime = queryTime + (i * time);

            /**
             * 把统计结果放入集合
             * 每统计一个，从集合中删除
             */
            while (userDeviceStats.size() > 0) {
                if (userDeviceStats.get(0).getCreateTime() > statTime) {
                    break;
                }
                userDeviceStats.remove(0);
                count++;
            }
            result[i] = count;

        }

        return result;
    }



    /**
     * 统计过去30天用户注册数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    @Override
    public Double[] statUserRegStat(int number, long time) {

        // 结果
        Double[] result = new Double[number];

        /**
         * 查询时间，按照 粒度 * 时间粒度
         */
        Calendar today = Calendar.getInstance();
        // 加1是为了包含今天
        today.add(Calendar.DAY_OF_MONTH, 1);
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        today.set(Calendar.MILLISECOND, 999);
        long queryTime = today.getTimeInMillis() - (time * number);

        // 组装参数
        QueryUserParam param = new QueryUserParam();
        param.setStartCreateTime(queryTime);
        param.setSortSection("A.uid ASC");
        param.setType(Consts.User.Type.AppUser);

        // 进行查询
        List<User> users = userDao.queryUserByParams(param);

        // 统计时间
        long statTime = 0l;

        /**
         * 遍历组装数据
         */
        for (int i = 0; i < number; i++) {

            // 记录统计数量
            double count = 0d;
            /**
             * 按天计算
             */
            statTime = queryTime + (i * time);

            /**
             * 把统计结果放入集合
             * 每统计一个，从集合中删除
             */
            while (users.size() > 0) {
                if (users.get(0).getCreateTime() > statTime) {
                    break;
                }
                users.remove(0);
                count++;
            }

            result[i] = count;
        }

        return result;
    }


    /**
     * 统计用户登录详细
     *
     * @return startTime 开始时间
     */
    public Double[] statUserLoginDetail(long startTime, long endTime) {

        // 产生多少小时
        int hours = (int) ((endTime - startTime) / DateUtil.ONE_HOUR_TIME) + 1;

        Double[] result = new Double[hours];

        // 把开始时间指向为0分0秒
        Calendar start = Calendar.getInstance();
        start.setTimeInMillis(startTime);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = Calendar.getInstance();
        end.setTimeInMillis(endTime);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);

        // 组装参数
        QueryUserLoginStatParam param = new QueryUserLoginStatParam();
        param.setStartCreateTime(start.getTimeInMillis());
        param.setEndCreateTime(end.getTimeInMillis());
        param.setSortSection("A.ulsId ASC");

        // 进行查询
        List<UserLoginStat> userLoginStats = userLoginStatDao.queryUserLoginStatByParam(param);

        // 设置第一个小时时间
        start.set(Calendar.MINUTE, 59);
        start.set(Calendar.SECOND, 59);
        start.set(Calendar.MILLISECOND, 999);
        long statTime = start.getTimeInMillis();

        // 遍历时间
        for (int i = 0, j = hours; i < j; i++) {

            // 记录统计量
            double count = 0d;

            statTime += i != 0 ? DateUtil.ONE_HOUR_TIME : 0;

            // 集合不为空
            while (userLoginStats.size() > 0) {
                if (userLoginStats.get(0).getCreateTime() > statTime) {
                    break;
                }
                userLoginStats.remove(0);
                count++;
            }
            result[i] = count;

        }

        return result;
    }
}
