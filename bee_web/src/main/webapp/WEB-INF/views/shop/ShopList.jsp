<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页 - 大黄蜂后台管理系统</title>

    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="../includes/navtop.jsp" %>
<%@ include file="../includes/navleft.jsp" %>
<div class="main">
    <ol class="breadcrumb">
        <li><a href="${basePath}/admin/index.html"><i class="fa fa-home fa-lg"></i>首页</a></li>
        <li class="active">商家管理</li>
    </ol>

</div>
<script src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>