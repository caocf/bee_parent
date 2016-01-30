<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>优惠券管理 - <spring:message code="application.name"/></title>

    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>
<body class="shop">
<%@ include file="../includes/navtop.jsp" %>
<%@ include file="../includes/navleft.jsp" %>
<%@ include file="MarketMenu.jsp" %>
<div class="main inner">
    <div class="row title">
        <span class="before">优惠券</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">查看和创建优惠券</span>
    </div>
    <div class="row query-inner">
        <a href="${basePath}/ticket/new" class="btn btn-primary icon-text">
            <i class="fa fa-plus font-color-white"></i>增加优惠券
        </a>
    </div>
    <table class="table table-hover">
        <tr>
            <th>主键</th>
            <th>类型</th>
            <th>标题</th>
            <th>价格</th>
            <th>所属商家</th>
        </tr>
        <c:forEach items="${Tickets}" var="ticket">
            <tr>
                <td>${ticket.tid}</td>
                <td>${ticket.typeStr}</td>
                <td>${ticket.title}</td>
                <td>${ticket.price}</td>
                <td>
                    <c:if test="${ticket.shop.sid > 0}">${ticket.shop.name}</c:if>
                    <c:if test="${ticket.shop.sid == 0}">无</c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript">
    Navbar.init("navbar-left-marketing", "navbar-inner-market-ticket");
</script>
</body>
</html>