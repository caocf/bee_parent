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
        <span class="before">添加优惠券</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">创建一个优惠券</span>
    </div>
    <div class="row">
        <div class="alert alert-danger <c:if test='${msg == null}'>hidden</c:if>" role="alert">${msg}</div>
    </div>
    <form id="submitForm" class="form-horizontal" action="${basePath}/ticket" method="post">
        <div class="form-group info-title">基本信息</div>
        <div class="form-group">
            <label class="col-xs-1 control-label">标题</label>
            <div class="col-xs-4">
                <input type="text" name="ticket.title" placeholder="优惠券标题,如（天降红包,活动奖品等）" class="form-control" value="${ticket.title}" />
            </div>
        </div>
    </form>
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