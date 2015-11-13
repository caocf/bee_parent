<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户列表 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="shop">
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="UserMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">用户列表</span>
        <i class="fa fa-angle-double-right"></i>  
        <span class="after">管理用户信息列表</span>
      </div>
      <form id="queryForm" class="form-inline" action="${basePath}/user" method="get">
        <input type="hidden" name="type" value="${params.type}" />
        <input type="hidden" id="indexPage" name="indexPage" value="${result.indexPage}" />
      </form>
      <table class="table table-hover">
        <tr>
          <th>主键</th>
          <th>手机号</th>
          <th>昵称</th>
          <th>等级</th>
          <th>积分</th>
          <th>加入时间</th>
          <th>操作</th>
        </tr>
        <c:if test="${result.totalData < 1}">
          <tr>
            <td colspan="6" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i>
              未查到任何数据
            </td>
          </tr> 
        </c:if>
        <c:forEach items="${result.data}" var="user">
          <tr>
            <td>${user.uid}</td>
            <td>${user.phone}<c:if test="${user.phone == '00000000000'}"> <span class="font-color-red">(测试帐号)</span></c:if></td>
            <td>${user.name}</td>
            <td>${user.level}</td>
            <td>${user.integral}</td>
            <td>${user.createTimeStr}</td>
            <td></td>
          </tr>
        </c:forEach>
      </table>
      <div id="paging" class="row"></div>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
    <script type="text/javascript">
  		Navbar.init("navbar-left-user", "${params.pageType}");
      $("#paging").paging({
        index: ${result.indexPage},
        total: ${result.totalPage},
          count: ${result.totalData},
        fn : function(r) {
          $("#indexPage").val(r);
          document.forms["queryForm"].submit();
        }
      });
  	</script>
  </body>
  </html>