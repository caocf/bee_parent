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
      <form id="queryForm" class="form-inline" action="${basePath}/order" method="get">
        <input type="hidden" id="statusType" value="${params.pageType}" />
        <input type="hidden" name="status" value="${params.status}" />
        <input type="hidden" id="indexPage" name="indexPage" value="${params.indexPage}" />
        <input type="hidden" id="isAuto" name="isAuto" value="${params.isAuto}" />
        <c:if test="${params.pageType == 'navbar-inner-order-ing'}">
          <button id="autoRefresh" type="button" class="btn btn-primary btn-sm icon-text" onclick="startAutoRefresh(this)">
            <i class="fa fa-play"></i>开启自动刷新
          </button>
          <button type="submit" class="btn btn-success btn-sm icon-text">
            <i class="fa fa-refresh"></i>手动刷新
          </button>
        </c:if>
      </form>
    </div>
    <table class="table table-hover">
        <tr>
            <th>订单编号</th>
            <th>预约商家</th>
            <th>商家电话</th>
            <th>预约人</th>
            <th>预约人数</th>
            <th>用户电话</th>
            <th>预约时间</th>
            <th>状态</th>
            <th>下单时间</th>
        </tr>
        <c:if test="${result.totalData < 1}">
          <tr>
            <td colspan="9" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 暂时没有新的订单
            </td>
          </tr>
        </c:if>
        <c:forEach items="${result.data}" var="order">
            <tr>
                <td>${order.no}</td>
                <td>${order.shop.name}</td>
                <td>${order.shopUser.phone}</td>
                <td>${order.orderName}</td>
                <td>${order.num}人</td>
                <td>${order.orderPhone}</td>
                <td>${order.execTimeStr}</td>
                <td>${order.statusStr}</td>
                <td>${order.createTimeStr}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${result.totalData > 0}">
      <div id="paging" class="row"></div>
    </c:if>
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
<script type="text/javascript">
    Navbar.init("navbar-left-order", "${params.pageType}");
    var intervalId = undefined;
    var autoTime = 300000;
    function autoRefresh(btn) {
      if ($("#isAuto").val() != "" && $("#isAuto").val() == "true") {
        $(btn).html("<i class=\"fa fa-stop\"></i>停止自动刷新");
        $(btn).removeClass('btn-primary');
        $(btn).addClass('btn-danger');
        $("#isAuto").val("true");
        intervalId = setInterval(function() {
          document.forms["queryForm"].submit();
        }, autoTime);
      } else {
        $(btn).html("<i class=\"fa fa-play\"></i>启动自动刷新");
        $(btn).removeClass('btn-danger');
        $(btn).addClass('btn-primary');
        $("#isAuto").val("false");
        if (intervalId != undefined) {
          window.clearInterval(intervalId);
        }
      }
    }
    function startAutoRefresh(btn) {
      var isAuto = $("#isAuto").val();
      if (isAuto == "" || isAuto == "false") {
        $("#isAuto").val("true");
      } else {
        $("#isAuto").val("false");
      }
      autoRefresh(btn);
    }
    $("#paging").paging({
      index: ${result.indexPage},
      total: ${result.totalPage},
      count: ${result.totalData},
      fn : function(r) {
        $("#indexPage").val(r);
        document.forms["queryForm"].submit();
      }
    });
    if ($("#statusType").val() == "navbar-inner-order-ing") {
      autoRefresh(document.getElementById("autoRefresh"));
    }
    
</script>
</body>
</html>