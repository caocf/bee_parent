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
    <%@ include file="ShopMenu.jsp" %>
    <div class="main inner">
      <table class="table table-hover">
        <tr>
          <th>
            <input type="checkbox" />
          </th>
          <th>商家名</th>
          <th>最低价</th>
          <th>地区</th>
          <th>联系人</th>
          <th>电话</th>
          <th>地址</th>
          <th>权重</th>
          <th>操作</th>
        </tr> 
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </table>
    </div>
<script src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>