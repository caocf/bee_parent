<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">订单管理</span>
	<span>在此可以管理和查看订单，并且可以处理订单，统计订单</span>
	<a id="navbar-inner-order-monitor" class="first" href="${basePath}/admin/order?status=<%=Consts.Order.Status.Query.Monitor %>">
		<i class="fa fa-eye"></i>订单监控
	</a>
	<a id="navbar-inner-order-ing" href="${basePath}/admin/order?status=<%=Consts.Order.Status.Query.Ing %>">
		<i class="fa fa-clock-o fa-lg"></i>正在进行
	</a>
	<a id="navbar-inner-order-end" href="${basePath}/admin/order?status=<%=Consts.Order.Status.Query.Finish %>">
		<i class="fa fa-check-circle-o fa-lg"></i>已完成
	</a>
</div>