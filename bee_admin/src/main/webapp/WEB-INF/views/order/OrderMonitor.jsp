<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex,nofollow">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单监控 - <spring:message code="application.name"/></title>

    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="main phone">
    <div class="row title">
        <span class="before">订单监控</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">监控和处理订单</span>
    </div>
    <div class="row margin-left-5">
        <form action="${basePath}/order/monitor" method="get">
            <button type="submit" class="btn btn-primary btn-sm icon-text">
                <i class="fa fa-refresh"></i>刷新
            </button>
        </form>
    </div>
    <c:forEach items="${result}" var="order">
        <div class="border bottom">
                <div class="row">
                    <div class="col-xs-8">
                        ${order.no}&nbsp;${order.shop.name}
                    </div>
                    <div class="col-xs-4 text-right">
                        ${order.statusStr}
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <c:if test="${order.user.uid > 0}">
                            ${order.user.name}
                        </c:if>
                        <c:if test="${order.user.uid == 0}">
                            <span class="font-color-red">未注册</span>
                        </c:if>
                        (${order.orderPhone})
                    </div>
                    <div class="col-xs-4 text-right">
                        ${order.num}人
                    </div>
                </div>
            <div class="row">
                <div class="col-xs-6">
                    ${order.execTimeStr}
                    </div>
                <div class="col-xs-6 text-right">
                    ${order.createTimeStr}
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">${order.remark}</div>
            </div>
        </div>
    </c:forEach>
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript">
</script>
</body>
</html>