<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户建议列表 - <spring:message code="application.name"/></title>

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
        <span class="before">用户建议列表</span>
        <i class="fa fa-angle-double-right"></i>  
        <span class="after">查看用户提交的建议</span>
      </div>
      <form id="queryForm" class="form-inline" action="${basePath}/advice" method="get">
        <input type="hidden" id="indexPage" name="indexPage" value="${result.indexPage}" />
      </form>
      <table class="table table-hover">
        <tr>
          <th>主键</th>
          <th>用户建议</th>
          <th>用户名</th>
          <th>联系手机</th>
          <th>发布时间</th>
        </tr>
        <c:if test="${result.totalData < 1}">
          <tr>
            <td colspan="6" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i>
              未查到任何数据
            </td>
          </tr> 
        </c:if>
        <c:forEach items="${result.data}" var="advice">
          <tr>
            <td>${advice.aid}</td>
            <td width="60%">${advice.msg}</td>
            <td>
              <c:if test="${advice.user.uid > 0}">
                ${advice.user.name}
              </c:if>
            </td>
            <td>${advice.phone}</td>
            <td>${advice.createTimeStr}</td>
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
  		Navbar.init("navbar-left-user", "navbar-inner-user-advice");
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