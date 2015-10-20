<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商家管理员列表 - <spring:message code="application.name"/></title>

    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="../includes/navtop.jsp" %>
<%@ include file="../includes/navleft.jsp" %>
<%@ include file="ShopMenu.jsp" %>
<div class="main inner">
    <div class="row title">
        <span class="before">商家管理员列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">${shopName}</span>
    </div>
    <div class="row query-inner">
        <a href="${basePath}/admin/shop/${sid}/admin/new" class="btn btn-primary icon-text" alt="增加管理员">
            <i class="fa fa-plus font-color-white"></i>
            增加管理员
        </a>
    </div>
    <form:form id="delForm" method="delete"></form:form>
    <table class="table table-hover">
        <tr>
            <th>主键</th>
            <th>帐号</th>
            <th>名字</th>
            <th>加入时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${result}" var="admins">
            <tr>
                <td>${admins.suid}</td>
                <td>${admins.user.phone}</td>
                <td>${admins.name}</td>
                <td>${admins.createTimeStr}</td>
                <td>
                    <a href="#" class="icon" role="button" onclick="deleteImage(${admins.suid})">
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
    Navbar.init("ShopAdmin");
    function deleteImage(id) {
        document.forms['delForm'].action = "${basePath}/admin/shop/${sid}/admin/" + id;
        document.forms['delForm'].submit();
    }
</script>
</body>
</html>