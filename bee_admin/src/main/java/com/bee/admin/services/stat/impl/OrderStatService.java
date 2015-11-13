package com.bee.admin.services.stat.impl;

import com.bee.admin.params.order.QueryOrderParam;
import com.bee.admin.services.stat.IOrderStatService;
import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.commons.Consts;
import com.bee.dao.order.OrderDao;
import com.bee.pojo.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by suntongwei on 15/10/7.
 */
@Service
public class OrderStatService implements IOrderStatService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 统计全部完成订单
     *
     * @param shopId 如果是0，则代表统计全部商户
     * @return
     */
    @Override
    public Double[] statFinishOrder(long shopId, int number, long time) {

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
        QueryOrderParam param = new QueryOrderParam();
        param.setShopId(shopId);
        param.setStatus(Consts.Order.Status.Finish);
        param.setStartCreateTime(queryTime);
        param.setSortSection("A.oid ASC");

        // 进行查询
        List<Order> orders = orderDao.queryOrderByParams(param);

        // 获取集合是否为空
        boolean isEmpty = orders.isEmpty();
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
                while (orders.size() > 0) {
                    Order order = orders.get(0);
                    if (order.getFinishTime() > statTime) {
                        break;
                    }
                    count += order.getNum();
                    orders.remove(0);
                }
            }
            result[i] = count;
        }

        return result;
    }
}
