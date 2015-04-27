<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">订单管理</span>
	<span>在此可以管理和查看订单，并且可以处理订单，统计订单</span>
	<a id="navbar-inner-order-monitor" class="first" href="${basePath}/admin/order">
		<i class="fa fa-eye"></i>订单监控
	</a>
	<a id="navbar-inner-order-list" href="${basePath}/admin/order?status=1">
		<i class="fa fa-clock-o fa-lg"></i>正在进行
	</a>
	<a id="navbar-inner-order-list" href="${basePath}/admin/order?status=2">
		<i class="fa fa-check-circle-o fa-lg"></i>已完成
	</a>
</div>