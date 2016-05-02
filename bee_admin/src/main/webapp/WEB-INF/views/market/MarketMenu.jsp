<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
    <span class="title">营销设置</span>
    <span>可管理广告，积分商城，商城物品等。</span>
    <a id="navbar-inner-market-find" class="first" href="${basePath}/find">
    	<i class="fa fa-star fa-fw"></i>发现列表
    </a>
	<!--
	<a id="navbar-inner-market-ad" class="first" href="${basePath}/admin/ad">
		<i class="fa fa-buysellads fa-lg"></i> 广告管理
	</a>
	<a id="navbar-inner-market-party" href="${basePath}/admin/party">
		<i class="fa fa-flag fa-lg"></i> 活动管理
	</a>
	<a id="navbar-inner-market-store" href="${basePath}/admin/store?indexPage=1">
		<i class="fa fa-shopping-cart fa-lg"></i> 积分商城
	</a>
	<a id="navbar-inner-market-phone" href="${basePath}/admin/store/0/phone">
		<i class="fa fa-mobile-phone fa-lg"></i>  手机充值卡
	</a>
	-->
	<div class="line"></div>
	<sec:security auth="<%=AuthName.TicketList %>">
	<a id="navbar-inner-market-ticket" href="${basePath}/ticket">
		<i class="fa fa-ticket fa-fw"></i>优惠券
	</a>
	</sec:security>
</div>
