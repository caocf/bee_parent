<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-left">
	<a id="navbar-left-home" href="${basePath}/admin">
		<i class="fa fa-home fa-lg2"></i>
		<span>首页</span>
	</a>
	<a id="navbar-left-order" href="${basePath}/admin/order/monitor">
		<i class="fa fa-file-text-o fa-lg"></i>
		<span>订单</span>
	</a>
	<a id="navbar-left-shop" href="${basePath}/admin/shop">
		<i class="fa fa-desktop fa-lg"></i>
		<span>商家</span>
	</a>
	<a id="navbar-left-party" href="${basePath}/admin/party">
		<i class="fa fa-flag fa-lg"></i>
		<span>活动</span>
	</a>
	<a id="navbar-left-user" href="${basePath}/admin/user?type=<%=Consts.User.Type.AppUser %>">
		<i class="fa fa-user fa-lg2"></i>
		<span>用户</span>
	</a>
	<a id="navbar-left-stat" href="${basePath}/admin/stat/user">
		<i class="fa fa-bar-chart fa-lg"></i>
		<span>统计</span>
	</a>
	<a id="navbar-left-marketing" href="${basePath}/admin/ad">
		<i class="fa fa-cloud fa-lg"></i>
		<span>营销</span>
	</a>
	<a id="navbar-left-finance" href="#">
		<i class="fa fa-credit-card fa-lg"></i>
		<span>账务</span>
	</a>
	<a id="navbar-left-system" href="${basePath}/admin/area">
		<i class="fa fa-cog fa-lg2"></i>
		<span>设置</span>
	</a>
</div>