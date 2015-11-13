<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-left">
	<a id="navbar-left-home" href="${basePath}/index">
		<i class="fa fa-home fa-lg2"></i>
		<span>首页</span>
	</a>
    <sec:security auth="<%=AuthName.Order %>">
	<a id="navbar-left-order" href="${basePath}/order?status=<%=Consts.Order.Status.Query.Ing %>">
		<i class="fa fa-file-text-o fa-lg"></i>
		<span>订单</span><label id="orderNewNum" class="badge red"></label>
	</a>
    </sec:security>
    <sec:security auth="<%=AuthName.Shop %>">
	<a id="navbar-left-shop" href="${basePath}/shop">
		<i class="fa fa-desktop fa-lg"></i>
		<span>商家</span>
	</a>
    </sec:security>
    <sec:security auth="<%=AuthName.User%>">
	<a id="navbar-left-user" href="${basePath}/user?type=<%=Consts.User.Type.AppUser %>">
		<i class="fa fa-user fa-lg2"></i>
		<span>用户</span>
	</a>
    </sec:security>
    <sec:security auth="<%=AuthName.Stat%>">
	<a id="navbar-left-stat" href="${basePath}/stat/user">
		<i class="fa fa-bar-chart fa-lg"></i>
		<span>统计</span>
	</a>
    </sec:security>
	<a id="navbar-left-marketing" href="${basePath}/ad">
		<i class="fa fa-cloud fa-lg"></i>
		<span>营销</span>
	</a>
	<a id="navbar-left-finance" href="#">
		<i class="fa fa-credit-card fa-lg"></i>
		<span>账务</span>
	</a>
	<a id="navbar-left-system" href="${basePath}/area">
		<i class="fa fa-cog fa-lg2"></i>
		<span>设置</span>
	</a>
</div>