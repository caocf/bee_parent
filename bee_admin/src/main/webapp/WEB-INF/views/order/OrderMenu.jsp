<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">订单管理</span>
	<span>在此可以管理和查看订单，并且可以处理订单，统计订单</span>
	<a id="navbar-inner-order-ing" class="first" href="${basePath}/order?status=<%=Consts.Order.Status.Query.Ing %>&indexPage=1">
		<i class="fa fa-clock-o fa-lg"></i>正在进行
	</a>
	<a id="navbar-inner-order-end" href="${basePath}/order?status=<%=Consts.Order.Status.Query.Finish %>&indexPage=1">
		<i class="fa fa-check-circle-o fa-lg"></i>已完成
	</a>
	<a id="navbar-inner-order-cancel" href="${basePath}/order?status=<%=Consts.Order.Status.Query.Cancel %>&indexPage=1">
		<i class="fa fa-times-circle-o fa-lg"></i>已取消
	</a>
</div>