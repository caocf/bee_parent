package com.bee.dao.order;

import com.bee.admin.params.order.QueryOrderParam;
import com.bee.app.model.order.OrderItem;
import com.bee.busi.model.order.BusiOrderItem;
import com.bee.busi.model.order.BusiOrderListItem;
import com.bee.busi.model.order.BusiOrderNumberStat;
import com.bee.busi.params.order.BusiOrderListRequest;
import com.bee.client.params.order.AdminOrderListRequest;
import com.bee.client.params.order.OrderListRequest;
import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.commons.SQL;
import com.bee.modal.OrderListItem;
import com.bee.pojo.order.Order;
import com.qsd.framework.commons.utils.DateUtil;
import com.qsd.framework.commons.utils.NumberUtil;
import com.qsd.framework.commons.utils.StringUtil;
import com.qsd.framework.hibernate.JpaDaoSupport;
import com.qsd.framework.hibernate.QueryDataConver;
import com.qsd.framework.hibernate.bean.DataEntity;
import com.qsd.framework.hibernate.bean.HQLEntity;
import com.qsd.framework.hibernate.bean.SQLEntity;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

/**
 * Created by suntongwei on 15/4/24.
 */
@Repository
public class OrderDao extends JpaDaoSupport<Order, Long> {

    /**
     * 根据参数获取订单列表
     *
     * @param request
     * @return
     */
    public PagingResult<Order> getOrderListByParam(AdminOrderListRequest request) {
        DataEntity entity = new HQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Order.getOrderListByParam);
        if(request.getStatus() != null) {
            sb.append(" and A.status " + Consts.Order.Status.Query.getQueryStatus(request.getStatus()));
        }
        if(request.getQueryTime() != null) {
            sb.append(" and A.createTime > ?");
            entity.setParam(request.getQueryTime());
        }
        if (request.getIndexPage() > 0) {
            entity.setPaging(request);
        }
        entity.setEntity(sb.toString());
        return queryWithPaging(entity);
    }

    /**
     * App（C端）获取订单列表
     *
     * @param request
     * @return
     */
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListRequest request) {
        SQLEntity entity = new SQLEntity();
        StringBuffer sb = new StringBuffer(SQL.Order.getAppOrderListByParam);
        if (request.getUid() != null) {
            sb.append(" and A.user = ?");
            entity.setParams(request.getUid());
        } else {
            if (request.getDevice() != null && !"".equals(request.getDevice())) {
                sb.append(" and A.device = ?");
                entity.setParams(request.getDevice());
            }
        }
        if (request.getStatus() != null) {
            sb.append(" and A.status " + Consts.Order.Status.Query.getQueryStatus(request.getStatus()));
        }
        entity.setQueryDataConver(new QueryDataConver<OrderListItem>() {
            @Override
            public OrderListItem converData(Object[] obj) {
                OrderListItem item = new OrderListItem();
                item.setName(StringUtil.parseString(obj[0], ""));
                item.setTime(NumberUtil.parseLong(obj[1], 0));
                item.setNum(NumberUtil.parseInteger(obj[2], 0));
                item.setStatus(NumberUtil.parseInteger(obj[3], Consts.Order.Status.Create));
                item.setOid(NumberUtil.parseLong(obj[4], 0));
                item.setShopId(NumberUtil.parseLong(obj[5], 0));
                item.setUserName(StringUtil.parseString(obj[6], ""));
                item.setExecTime(NumberUtil.parseLong(obj[7], 0));
                item.setPhone(StringUtil.parseString(obj[8], ""));
                item.setRemark(StringUtil.parseString(obj[9], ""));
                return item;
            }
        });
        if (request.getIsCurOrder() == Consts.True) {
            entity.setPaging(request);
        }
        sb.append(SQL.Order.getOrderListByParamOrder);
        entity.setEntity(sb.toString());
        return queryWithPagingConver(entity);
    }

    /**
     * 获取商户端订单列表
     *
     * @param request
     * @return
     */
    public List<BusiOrderListItem> getBusiOrderListByParam(BusiOrderListRequest request) {
        if (null == request || null == request.getShopId() || request.getShopId() <= 0) {
            throw new DataRunException(Codes.ParamsError);
        }
        StringBuffer sb = new StringBuffer(SQL.Order.getBusiOrderListByParam);
        if (request.getStatus() != null) {
            sb.append(" and A.status = " + request.getStatus());
        } else if (request.getQueryStatus() != null) {
            sb.append(" and " + Consts.Order.Status.Query.getQueryString("A.status", request.getQueryStatus()));
        }
        sb.append(SQL.Order.getBusiOrderListByParamOrderBy);
        return findConverByParams(sb.toString(), new QueryDataConver<BusiOrderListItem>() {
            @Override
            public BusiOrderListItem converData(Object[] objects) {
                BusiOrderListItem item = new BusiOrderListItem();
                int i = 0;
                item.setOid(NumberUtil.parseLong(objects[i++], 0));
                item.setOrderNo(StringUtil.parseString(objects[i++], ""));
                item.setStatus(NumberUtil.parseInteger(objects[i++], Consts.Order.Status.Unknow));
                item.setNum(NumberUtil.parseInteger(objects[i++], 1));
                item.setOrderTime(NumberUtil.parseLong(objects[i++], 0));

                // 预订用户名，如没有User则使用orderName
                String orderName = StringUtil.parseString(objects[i++], "");

                // 处理订单用户
                Long userId = NumberUtil.parseLong(objects[i++], 0);
                String userName = StringUtil.parseString(objects[i++], "");
                if (userId > 0) {
                    item.setUserId(userId);
                    item.setUserName(userName);
                } else {
                    item.setUserId(0l);
                    item.setUserName(orderName);
                }

                item.setCreateTime(NumberUtil.parseLong(objects[i++], 0));
                item.setHisNum(NumberUtil.parseInteger(objects[i++], 0));
                item.setUserLevel(NumberUtil.parseInteger(objects[i++], 0));
                return item;
            }
        }, request.getShopId(), request.getShopId());
    }

    /**
     * [B端]根据订单ID查询商户端订单详细
     *
     * @return
     */
    public BusiOrderItem getBusiOrderItem(long oid) {
        return findFirstConverByParams(SQL.Order.GetBusiOrderItem, new QueryDataConver<BusiOrderItem>() {
            @Override
            public BusiOrderItem converData(Object[] obj) {
                BusiOrderItem item = new BusiOrderItem();
                int i = 0;
                item.setOid(NumberUtil.parseLong(obj[i++], 0));
                item.setNo(StringUtil.parseString(obj[i++], ""));
                item.setNum(NumberUtil.parseInteger(obj[i++], 1));
                item.setCreateTime(NumberUtil.parseLong(obj[i++], 0));
                item.setExecTime(NumberUtil.parseLong(obj[i++], 0));

                // 预订用户名，如没有User则使用orderName
                String orderName = StringUtil.parseString(obj[i++], "");

                // 处理订单用户
                Long userId = NumberUtil.parseLong(obj[i++], 0);
                String userName = StringUtil.parseString(obj[i++], "");
                if (userId > 0) {
                    item.setUserId(userId);
                    item.setUserName(userName);
                } else {
                    item.setUserId(0l);
                    item.setUserName(orderName);
                }

                item.setUserPhone(StringUtil.parseString(obj[i++], ""));
                item.setRemark(StringUtil.parseString(obj[i++], ""));
                item.setStatus(NumberUtil.parseInteger(obj[i++], Consts.Order.Status.Unknow));
                item.setUserLevel(NumberUtil.parseInteger(obj[i++], 0));
                return item;
            }
        }, oid);
    }

    /**
     * 【C端】根据订单ID查询订单详细（OrderDetail）
     *
     * @param oid
     * @return
     */
    public OrderItem queryOrderByOid(long oid) {
        return findFirstConverByParams(SQL.Order.QueryOrderByOid, new QueryDataConver<OrderItem>() {
            @Override
            public OrderItem converData(Object[] objects) {
                OrderItem item = new OrderItem();
                item.setNo(StringUtil.parseString(objects[0], ""));
                item.setCreateTime(NumberUtil.parseLong(objects[1], 0));
                item.setStatus(NumberUtil.parseInteger(objects[2], Consts.Order.Status.Unknow));
                item.setAddr(StringUtil.parseString(objects[3], ""));
                item.setShopPhone(StringUtil.parseString(objects[4], ""));
                item.setIsComment(NumberUtil.parseInteger(objects[5], Consts.False));
                return item;
            }
        }, oid);
    }

    /**
     * 查询B端订单统计
     * 今日成功订单数，今日总订单数，一周（周期）总订单数
     *
     * @param shopId 商家ID
     * @return BusiOrderNumberStat
     */
    public BusiOrderNumberStat queryBusiOrderNumberStat(long shopId) {

        BusiOrderNumberStat stat = new BusiOrderNumberStat();

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);


        // 查询今天成功订单数
        stat.setToday(
                getDataCount(SQL.Order.Stat.QueryBusiOrderNumberStat + " = " + Consts.Order.Status.Finish,
                        shopId, today.getTimeInMillis()).intValue()
        );

        // 查询今日总订单数
        stat.setTodayTotal(
                getDataCount(SQL.Order.Stat.QueryBusiOrderNumberStat + " = " + Consts.Order.Status.Unknow,
                        shopId, today.getTimeInMillis()).intValue()
        );

        // 设置时间为过去七天
        today.add(Calendar.DAY_OF_MONTH, -7);

        // 查询一周总订单数
        stat.setTotal (
                getDataCount(SQL.Order.Stat.QueryBusiOrderNumberStat + " = " + Consts.Order.Status.Finish,
                        shopId, today.getTimeInMillis()).intValue()
        );

        return stat;
    }

    /**
     * 根据参数查询订单
     *
     * @return
     */
    public List<Order> queryOrderByParams(QueryOrderParam param) {

        // 创建查询实体
        HQLEntity entity = new HQLEntity();

        // 创建查询语句
        StringBuffer sb = new StringBuffer(SQL.Order.QueryOrderByParams);

        /**
         * 设置参数
         */
        if (param != null) {

            /**
             * 如果shopId不等于0，则查询全部
             */
            if (param.getShopId() != null && param.getShopId() > 0) {
                sb.append(" and B.sid = ?");
                entity.setParams(param.getShopId());
            }

            /**
             * 根据状态查询
             */
            if (param.getStatus() != null) {
                sb.append(" and A.status = ?");
                entity.setParams(param.getStatus());
            }

            /**
             * 查询起始创建时间，根据用户注册时间开始计算
             */
            if (param.getStartCreateTime() != null) {
                sb.append(" and A.createTime >= ?");
                entity.setParams(param.getStartCreateTime());
            }

            /**
             * 增加排序部分
             * 必须放在param最后
             */
            if (!StringUtil.isNull(param.getSortSection())) {
                sb.append(" ORDER BY ");
                sb.append(param.getSortSection());
            }
        }
        // 导入HQL
        entity.setEntity(sb);
        return queryResult(entity);
    }
}
