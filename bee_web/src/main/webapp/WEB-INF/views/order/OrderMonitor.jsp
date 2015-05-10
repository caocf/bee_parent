<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex,nofollow">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单监控 - <spring:message code="application.name"/></title>

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
        <span class="before">订单监控</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">监控和处理订单</span>
    </div>
    <table id="orderMonitorTable" class="table table-hover">
        <tr>
            <th>订单号</th>
            <th>类型</th>
            <th>预约商家</th>
            <th>预约人</th>
            <th>预约人数</th>
            <th>用户电话</th>
            <th>预约时间</th>
            <th>订单时间</th>
            <th>操作</th>
        </tr>
    </table>
</div>
<div class="modal fade" id="execuModal" tabindex="-1" role="dialog" aria-labelledby="execuModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="execuModalLabel">处理订单</h4>
      </div>
      <div class="modal-body">
        <input type="hidden" id="dialogOrderId" />
        <dl id="dialogShopInfo" class="clear-all">
          <dt>商家信息</dt>
          <dd class="pull-left">商家名称：</dd>
          <dd class="clearfix"></dd>
          <dd class="pull-left">联系人：</dd>
          <dd class="clearfix"></dd>
          <dd class="pull-left">联系电话：</dd>
          <dd></dd>
        </dl>
        <hr />
        <dl id="dialogUserInfo">
          <dt>预订人信息</dt>
          <dd class="pull-left">预订人：</dd>
          <dd class="clearfix"></dd>
          <dd class="pull-left">预约时间：</dd>
          <dd class="clearfix"></dd>
          <dd class="pull-left">联系电话：</dd>
          <dd></dd>
        </dl>
      </div>
      <div class="modal-footer">
        <button id="orderEnter" type="button" class="btn btn-success icon-text" data-dismiss="modal">
          <i class="fa fa-check"></i>接受订单
        </button>
        <button id="orderCancel" type="button" class="btn btn-danger icon-text" data-dismiss="modal">
          <i class="fa fa-times"></i>取消订单
        </button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/jquery/json2.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript">
    Navbar.init("OrderMonitor");
    Order.Monitor.init();
</script>
</body>
</html>