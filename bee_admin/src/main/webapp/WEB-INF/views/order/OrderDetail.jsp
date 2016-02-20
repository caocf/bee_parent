<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单详细 - <spring:message code="application.name"/></title>
    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <%@ include file="../includes/navtop.jsp" %>
    <%@ include file="../includes/navleft.jsp" %>
    <%@ include file="OrderMenu.jsp" %>
    <div class="main inner">
        <div class="row title">
            <span class="before">订单详细</span>
            <i class="fa fa-angle-double-right"></i>
            <span class="after">查看订单详细</span>
        </div>
        <form id="orderForm" class="form-horizontal" action="${basePath}/order" method="post">
        </form>
        <div class="table-view info-title">基本信息</div>
        <div class="table-view">
            <label class="col-xs-1 name">订单编号</label>
            <div class="col-xs-4 text">${order.no}</div>
            <label class="col-xs-2 name">订单状态</label>
            <div class="col-xs-4 text">${order.statusStr}</div>
        </div>
        <div class="table-view">
            <label class="col-xs-1 name">预约时间</label>
            <div class="col-xs-4 text">${order.execTimeStr}</div>
            <label class="col-xs-2 name">预约人数</label>
            <div class="col-xs-5 text">${order.num}人</div>
        </div>
        <div class="table-view">
            <label class="col-xs-1 name">下单时间</label>
            <div class="col-xs-11 text">${order.createTimeStr}</div>
        </div>
        <c:if test="${ticket != null}">
            <div class="table-view info-title">优惠信息</div>
            <div class="table-view">
                <label class="col-xs-1 name">优惠券</label>
                <div class="col-xs-4 text">${ticket.ticket.typeStr}</div>
                <label class="col-xs-2 name">优惠价格</label>
                <div class="col-xs-5 text">${ticket.ticket.price}</div>
            </div>
        </c:if>
        <div class="table-view info-title">用户信息</div>
        <div class="table-view">
            <label class="col-xs-1 name">预约人</label>
            <div class="col-xs-4 text">${order.orderName}&nbsp;<c:if test="${order.isRegUser}">(注册用户)</c:if></div>
            <label class="col-xs-2 name">预约电话</label>
            <div class="col-xs-5 text">${order.orderPhone}</div>
        </div>
        <c:if test="${order.user.uid > 0}">
            <div class="table-view">
                <label class="col-xs-1 name">用户等级</label>
                <div class="col-xs-4 text">${order.user.level}</div>
                <label class="col-xs-2 name">用户积分</label>
                <div class="col-xs-5 text">${order.user.integral}</div>
            </div>
        </c:if>
        <div class="table-view">
            <label class="col-xs-1 name">设备号</label>
            <div class="col-xs-11 text">${order.device}</div>
        </div>
        <div class="table-view info-title">商家信息</div>
        <div class="table-view">
            <label class="col-xs-1 name">预约商家</label>
            <div class="col-xs-4 text">${order.shop.name}</div>
            <label class="col-xs-2 name">商家电话</label>
            <div class="col-xs-5 text">${order.shopUser.phone}(${order.shopUser.name})</div>
        </div>
        <div class="table-view">
            <label class="col-xs-1 name">商家地址</label>
            <div class="col-xs-11 text">${order.shop.area.name}${order.shop.address}</div>
        </div>
        <div class="table-view info-title">操作日志</div>
        <div class="table-view">
            <div class="col-xs-12 text">${order.operateStr}</div>
        </div>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript">
        Navbar.init("navbar-left-order", "");
    </script>
</body>
</html>
