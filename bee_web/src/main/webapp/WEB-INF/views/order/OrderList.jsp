<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单列表 - 大黄蜂后台管理系统</title>

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
    <table class="table table-hover">
        <tr>
            <th>订单编号</th>
            <th>类型</th>
            <th>状态</th>
            <th>商家</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>订单时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${result.data}" var="order">
            <tr>
                <td>${order.oid}</td>
                <td>${order.shop.typeStr}</td>
                <td>${order.statusStr}</td>
                <td>${order.shop.name}</td>
                <td>${order.shop.linkName}</td>
                <td>${order.shop.phone}</td>
                <td>${order.createTimeStr}</td>
                <td>
                  <c:if test="${order.status == 1}">
                    <a href="#" class="icon" role="button" onclick="Order.doCheck(${order.oid});">
                      <i class="fa fa-check-square-o fa-lg"></i>
                    </a>
                  </c:if>
                  <a href="#" class="icon" role="button" onclick="">
                    <i class="fa fa-trash font-color-red fa-lg"></i>
                  </a>
                </td>
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
    Navbar.init("${params.pageType}");
</script>
</body>
</html>