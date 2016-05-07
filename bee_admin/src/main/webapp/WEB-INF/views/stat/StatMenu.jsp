<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">系统统计</span>
	<span>在此可以统计各类用户和商户信息，分析数据</span>
	<a id="navbar-inner-stat-visit" class="first" href="${basePath}/stat/visit">
		<i class="fa fa-sellsy"></i>访问统计
	</a>
	<a id="navbar-inner-stat-user" href="${basePath}/stat/user">
		<i class="fa fa-bar-chart"></i>用户统计
	</a>
	<a id="navbar-inner-stat-shop" href="${basePath}/stat/shop">
		<i class="fa fa-area-chart"></i>商家统计
	</a>
	<a id="navbar-inner-stat-order" href="${basePath}/stat/order">
		<i class="fa fa-line-chart"></i>订单统计
	</a>
</div>