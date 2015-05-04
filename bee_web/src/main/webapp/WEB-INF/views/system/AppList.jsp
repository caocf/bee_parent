<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>App版本管理 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="shop">
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="SystemMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">App版本列表</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">查看App版本列表</span>
      </div>
      <table class="table table-hover">
      	<tr>
      		<th>主键</th>
          <th>版本类型</th>
      		<th>版本号</th>
      		<th>版本码</th>
          <th>发布日期</th>
          <th>操作</th>
      	</tr>
      	<c:forEach items="${AppList}" var="app">
          <tr>
            <td>${app.avid}</td>
            <td>${app.typeStr}</td>
            <td>${app.ver}</td>
            <td>${app.verStr}</td>
            <td>${app.createTimeStr}</td>
            <td><a href="${app.path}">下载</a></td>
          </tr>
      	</c:forEach>
      </table>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript">
  		Navbar.init("AppList");
  	</script>
  </body>
  </html>