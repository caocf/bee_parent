package com.bee.services.stat.impl;

import com.bee.admin.params.stat.QueryUserLoginStatParam;
import com.bee.admin.params.user.QueryUserParam;
import com.bee.dao.stat.UserLoginStatDao;
import com.bee.dao.stat.UserRegStatDao;
import com.bee.dao.user.UserDao;
import com.bee.pojo.stat.UserLoginStat;
import com.bee.pojo.user.User;
import com.bee.services.stat.IUserStatService;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.hibernate.exception.DataRunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by suntongwei on 15/4/28.
 */
@Service
public class UserStatService implements IUserStatService {

    @Autowired
    private UserLoginStatDao userLoginStatDao;
    @Autowired
    private UserRegStatDao userRegStatDao;
    @Autowired
    private UserDao userDao;

    /**
     * 记录用户登录
     *
     * @param uid
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void addUserLoginStat(long uid, String device) throws DataRunException {
        UserLoginStat stat = new UserLoginStat();
        stat.setUser(new User(uid));
        stat.setCreateTime(System.currentTimeMillis());
        stat.setDevice(device);
        userLoginStatDao.save(stat);
    }

    /**
     * 统计过去number天用户登录数量
     *
     * @param number 切割粒度
     * @param time   时间粒度(长整型)，按长整型时间作为切割粒度
     * @return
     */
    @Override
    public Double[] statUserLogin(int number, long time) {

        Double[] result = new Double[number];

        /**
         * 查询时间，按照 粒度 * 时间粒度
         */
        long queryTime = System.currentTimeMillis() - (time * number);

        // 组装参数
        QueryUserLoginStatParam param = new QueryUserLoginStatParam();
        param.setStartCreateTime(queryTime);
        param.setSortSection("A.ulsId ASC");

        // 进行查询
        List<UserLoginStat> userLoginStats = userLoginStatDao.queryUserLoginStatByParam(param);

        // 获取集合是否为空
        boolean isEmpty = userLoginStats.isEmpty();
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
             * 如果集合不为空
             */
            if (!isEmpty) {
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
        long queryTime = System.currentTimeMillis() - (time * number);

        // 组装参数
        QueryUserParam param = new QueryUserParam();
        param.setStartCreateTime(queryTime);
        param.setSortSection("A.createTime ASC");

        // 进行查询
        List<User> users = userDao.queryUserByParams(param);

        // 获取集合是否为空
        boolean isEmpty = users.isEmpty();
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
             * 如果集合不为空
             */
            if (!isEmpty) {
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
            }
            result[i] = count;
        }

        return result;
    }
}
