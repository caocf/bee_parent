<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>手机充值卡列表 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="shop">
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="MarketMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">手机充值卡列表</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">查看和管理手机充值卡</span>
      </div>
      <div class="row query-inner">
        <form id="queryForm" class="form-inline" action="${basePath}/admin/store/${goodsId}/phone" method="get">
          <input type="hidden" name="indexPage" id="indexPage" value="${result.indexPage}" />
        </form>
        <a href="${basePath}/admin/store/0/phone/new" class="btn btn-primary icon-text">
          <i class="fa fa-plus font-color-white"></i>增加充值卡
        </a>
      </div>
      <table class="table table-hover">
        <tr>
          <th>主键</th>
          <th>充值卡类型</th>
          <th>充值卡卡密</th>
          <th>状态</th>
          <th>创建时间</th>
          <th>操作</th>
        </tr>	
        <c:forEach items="${result.data}" var="phone">
          <tr>
            <td>${phone.pcId}</td>
            <td>${phone.operatorStr}</td>
            <td>${phone.cardNumber}</td>
            <td>${phone.statusStr}</td>
            <td>${phone.createTimeStr}</td>
            <td>
              <c:if test="${phone.status == 1}">
                <a href="${basePath}/admin/store/0/phone/${phone.pcId}/edit" class="icon">
                  <i class="fa fa-pencil font-color-base fa-lg"></i>
                </a>
              </c:if>
              <a href="#" class="icon">
                <i class="fa fa-trash font-color-red fa-lg"></i>
              </a>
            </td>
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
  		Navbar.init("navbar-left-marketing", "navbar-inner-market-phone");
      $("#paging").paging({
        index: ${result.indexPage},
        total: ${result.totalPage},
        fn : function(r) {
          $("#indexPage").val(r);
          document.forms["queryForm"].submit();
        }
      });
  	</script>
  </body>
  </html>