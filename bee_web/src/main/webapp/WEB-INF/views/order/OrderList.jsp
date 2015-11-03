<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单列表 - <spring:message code="application.name"/></title>

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
    <div class="row query-inner">
      <form id="queryForm" class="form-inline" action="${basePath}/admin/order" method="get">
        <input type="hidden" id="statusType" value="${params.pageType}" />
        <input type="hidden" name="status" value="<%=Consts.Order.Status.Query.Ing %>" />
        <button type="submit" class="btn btn-primary btn-sm icon-text">
            <i class="fa fa-refresh"></i>刷新
          </button>
      </form>
    </div>
    <table class="table table-hover">
        <tr>
            <th>订单编号</th>
            <th>类型</th>
            <th>预约商家</th>
            <th>商家电话</th>
            <th>预约人</th>
            <th>预约人数</th>
            <th>用户电话</th>
            <th>预约时间</th>
            <th>状态</th>
        </tr>
        <c:forEach items="${result.data}" var="order">
            <tr>
                <td>${order.no}</td>
                <td>${order.shop.typeStr}</td>
                <td>${order.shop.name}</td>
                <td>${order.shopUser.phone}</td>
                <td>${order.orderName}</td>
                <td>${order.num}人</td>
                <td>${order.orderPhone}</td>
                <td>${order.execTimeStr}</td>
                <td>${order.statusStr}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="checkModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="checkModalLabel">处理订单</h4>
      </div>
      <div class="modal-body">
        商家是否同意接受该订单？
      </div>
      <div class="modal-footer">
        <form:form id="checkForm" method="put"></form:form>
        <button type="button" class="btn btn-success icon-text" data-dismiss="modal" onclick="Order.doCheckSubmit(true);">
          <i class="fa fa-check"></i>接受订单
        </button>
        <button type="button" class="btn btn-danger icon-text" data-dismiss="modal" onclick="Order.doCheckSubmit(false);">
          <i class="fa fa-times"></i>取消订单
        </button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript">
    Navbar.init("navbar-left-order", "${params.pageType}");
    if ("${params.pageType}" == "navbar-inner-order-ing") {
      Order.Monitor.stop();
      Order.Monitor.resetQueryOrderTime();
      Order.Monitor.setOrderNewNum(0);
    }
</script>
</body>
</html>