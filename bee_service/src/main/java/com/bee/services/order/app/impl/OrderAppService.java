package com.bee.services.order.app.impl;

import com.bee.commons.Codes;
import com.bee.commons.Consts;
import com.bee.commons.OrderStatusMachine;
import com.bee.dao.order.app.OrderAppDao;
import com.bee.dao.shop.ShopDao;
import com.bee.dao.shop.ShopUserDao;
import com.bee.dao.shop.app.ShopAppDao;
import com.bee.dao.ticket.UserTicketDao;
import com.bee.domain.modal.app.order.OrderItem;
import com.bee.domain.modal.app.order.OrderListItem;
import com.bee.domain.params.order.OrderListParam;
import com.bee.pojo.order.Order;
import com.bee.pojo.shop.ShopUser;
import com.bee.pojo.tickets.UserTicket;
import com.bee.services.order.app.IOrderAppService;
import com.bee.services.order.impl.OrderService;
import com.easemob.server.comm.Constants;
import com.easemob.server.comm.HTTPMethod;
import com.easemob.server.comm.Roles;
import com.easemob.server.httpclient.utils.HTTPClientUtils;
import com.easemob.server.httpclient.vo.ClientSecretCredential;
import com.easemob.server.httpclient.vo.Credential;
import com.easemob.server.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qsd.framework.hibernate.exception.DataRunException;
import com.qsd.framework.spring.PagingResult;
import com.sun.deploy.association.utility.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by suntongwei on 15/11/25.
 */
@Service
public class OrderAppService extends OrderService implements IOrderAppService {

    // Log
    private static final Logger Log = LoggerFactory.getLogger(OrderAppService.class);

    @Autowired
    private OrderAppDao orderAppDao;
    @Autowired
    private ShopAppDao shopDao;
    @Autowired
    private ShopUserDao shopUserDao;


    /**
     * 创建订单
     *
     * @param order
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void createOrder(Order order) throws DataRunException {

        // 先填写空的NO号，等订单创建成功后，使用ID号
        order.setNo("");
        // 添加订单类型, 该字段无效
        order.setType(Consts.Order.Type.Master);
        // 添加订单创建时间
        order.setCreateTime(System.currentTimeMillis());
        // 设置订单初始化状态
        order.setStatus(Consts.Order.Status.Create);
        // 设置操作记录
        order.writeOperate(Consts.Order.Operate.Create);
        // 设置订单是否评论状态
        order.setIsComment(Consts.False);
        // 设置结束时间为0
        order.setFinishTime(0l);
        // 设置是否返现，默认为否
        order.setIsBack(Consts.False);
        // 查询订单商家
        order.setShop(shopDao.getShopById(order.getShop().getSid()));
        // 查询接待经理
        // 目前实现单经理模式
        ShopUser shopUser = shopUserDao.getShopUserByShopId(order.getShop().getSid());
        if (null == shopUser) {
            // 如果商家经理不存在，则填0处理
            shopUser = new ShopUser(0l);
        }
        order.setShopUser(shopUser);
        // 保存订单
        orderDao.save(order);

        // 处理优惠券红包
        if (!order.getUserTickets().isEmpty()) {
            Set<UserTicket> tickets = order.getUserTickets();
            for (UserTicket ticket : tickets) {
                UserTicket userTicket = userTicketDao.findById(ticket.getUtId());
                // 判断红包状态
                if (!userTicket.isUseTicket()) {
                    throw new DataRunException(Codes.Order.OrderTicketExpired, "红包过期");
                }
                userTicket.setStatus(Consts.Ticket.Status.Useing);
                userTicket.setOrder(order);
                userTicketDao.update(userTicket);
            }
        }

        /**
         * 如果商家管理员存在，则发消息通知B端
         */
        if (!Consts.isDebug && shopUser.getSuid() > 0l) {

            Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
                    Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);

            // 目标用户
            ArrayNode target = JsonNodeFactory.instance.arrayNode();
            target.add(shopUser.getUser().getHXName());

            // 消息体
            ObjectNode txtmsg = JsonNodeFactory.instance.objectNode();
            txtmsg.put("msg", "您有一条新订单");
            txtmsg.put("type","txt");

            // 消息扩展字段
            ObjectNode ext = JsonNodeFactory.instance.objectNode();
            ext.put("orderId", order.getOid());

            ObjectNode dataNode = JsonNodeFactory.instance.objectNode();
            dataNode.put("target_type", "users");
            dataNode.put("target", target);
            dataNode.put("msg", txtmsg);
            dataNode.put("from", Consts.HXConfig.SystemAdminHXName);
            dataNode.put("ext", ext);

            ObjectNode res = HTTPClientUtils.sendHTTPRequest(EndPoints.MESSAGES_URL, credential, dataNode,
                    HTTPMethod.METHOD_POST);

            if (res != null) {
                Log.info("给用户发一条透传消息: " + res.toString());
                Log.debug("[HX_Response]CMD:" + res.toString());
            }

        }
    }

    /**
     *
     *
     * @param param
     * @return
     */
    @Override
    public PagingResult<OrderListItem> getAppOrderListByParam(OrderListParam param) {
        return orderAppDao.getAppOrderListByParam(param);
    }

    /**
     * 查询订单
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderItem queryOrderItemById(long orderId) {
        return orderAppDao.queryOrderItemById(orderId);
    }

    /**
     * 用户取消订单
     *
     * @param id
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void cancelOrder(long id) throws DataRunException {
        Order order = orderDao.findById(id);
        // 判断订单是否可以取消
        if (!OrderStatusMachine.isCancelOrder(order.getStatus())) {
            throw new DataRunException(Codes.Order.CancelError, Codes.Order.CancelErrorStr);
        }
        order.setFinishTime(System.currentTimeMillis());
        order.setStatus(Consts.Order.Status.CancelUser);
        order.writeOperate(Consts.Order.Operate.UserCancel);
        orderDao.update(order);
        // 判断订单是否使用红包
        if (order.getUser() != null && order.getUser().getUid() > 0) {
            cancelOrderAndTicket(order.getUser().getUid(), order.getOid());
        }
    }

    /**
     * 修改订单人数
     *
     * @param oid
     * @param num
     * @throws DataRunException
     */
    @Override
    @Transactional
    public void changeOrderNum(long oid, int num) throws DataRunException {
        Order order = orderDao.findById(oid);
        // 判断订单是否可以被修改
        if (!OrderStatusMachine.isEditOrderNum(order.getStatus())) {
            throw new DataRunException(Codes.Order.EditError);
        }
        if (null == order.getNum() || num == order.getNum()) {
            throw new DataRunException(Codes.Order.EditNoChangeError);
        }
        order.setNum(num);
        order.writeOperate(Consts.Order.Operate.Edited);
        orderDao.update(order);
    }
}
