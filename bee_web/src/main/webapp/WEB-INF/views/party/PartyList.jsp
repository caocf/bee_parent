<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>活动列表 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="PartyMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">活动列表</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">查看活动列表</span>
      </div>
      <table class="table table-hover">
      	<tr>
      		<th>主键</th>
          <th>类型</th>
          <th>标题</th> 
      		<th>活动时间</th>
          <th>查看数</th>
          <th>状态</th>
          <th>操作</th>
      	</tr>
      	<c:forEach items="${PartyList}" var="party">
          <tr>
            <td>${party.pid}</td>
            <td>${party.typeStr}</td>
            <td>${party.title}</td>
            <td>${party.partyTime}</td>
            <td>${party.lookNum}</td>
            <td>${party.status}</td>
            <td></td>
          </tr>
      	</c:forEach>
      </table>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript">
  		Navbar.init("PartyList");
  	</script>
  </body>
  </html>