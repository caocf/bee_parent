<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>地区管理 - <spring:message code="application.name"/></title>

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
        <span class="before">地区列表</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">系统地区管理列表</span>
      </div>
      <div class="row query-inner">
        <a href="${basePath}/area/new" class="btn btn-primary icon-text">
          <i class="fa fa-plus font-color-white"></i>增加地区
        </a>
      </div>
      <table class="table table-hover">
      	<tr>
      		<th>主键</th>
      		<th>地区</th>
      		<th>父类ID</th>
      		<th>排序</th>
      		<th>操作</th>
      	</tr>
      	<c:forEach items="${result}" var="area">
	      	<tr>
	      		<td>${area.aid}</td>
	      		<td>${area.name}</td>
	      		<td>${area.parentId}</td>
	      		<td>${area.sort}</td>
	      		<td>
	      			<a href="${basePath}/area/new" class="icon" role="button">
                <i class="fa fa-plus fa-lg"></i>
              </a>
	      			<a href="${basePath}/area/${area.aid}/edit" class="icon" role="button">
                <i class="fa fa-pencil fa-lg"></i>
              </a>
      				<a href="#" class="icon" role="button" onclick="">
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
  		Navbar.init("navbar-left-system", "navbar-inner-system-area");
  	</script>
  </body>
  </html>