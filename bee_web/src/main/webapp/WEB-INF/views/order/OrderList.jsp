<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单列表 - 大黄蜂后台管理系统</title>

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
        <span class="before">订单列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">订单管理列表</span>
    </div>
    <table class="table table-hover">
        <tr>
            <th>订单编号</th>
            <th>类型</th>
            <th>状态</th>
            <th>商家</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${result.data}" var="order">
            <tr>
                <td>${order.oid}</td>
                <td>${order.type}</td>
                <td>${order.status}</td>
                <td>${order.shop.name}</td>
                <td>${order.shop.linkName}</td>
                <td>${order.shop.phone}</td>
                <td>
                    <a href="${basePath}/admin/area/new" class="icon" role="button">
                        <i class="fa fa-plus fa-lg"></i>
                    </a>
                    <a href="${basePath}/admin/shop/${sid}/image/${image.siid}/edit" class="icon" role="button">
                        <i class="fa fa-pencil fa-lg"></i>
                    </a>
                    <a href="#" class="icon" role="button" onclick="deleteImage(${image.siid})">
                        <i class="fa fa-trash font-color-red fa-lg"></i>
                    </a>
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
    Navbar.init("OrderList");
</script>
</body>
</html>