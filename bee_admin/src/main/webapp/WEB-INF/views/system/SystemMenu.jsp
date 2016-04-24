<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">系统设置</span>
	<span>可发布APP，设置地区</span>
	<sec:security auth="<%=AuthName.AppVer %>">
	<a id="navbar-inner-system-app" class="first" href="${basePath}/appver">
		 <i class="fa fa-mobile-phone fa-lg"></i> APP版本
	</a>
	</sec:security>
	<sec:security auth="<%=AuthName.AppVerNew %>">
	<a id="navbar-inner-system-app-new" href="${basePath}/appver/new">
		<i class="fa fa-paper-plane-o"></i>APP发布
	</a>
	</sec:security>
	<a id="navbar-inner-system-area" href="${basePath}/area">
		<i class="fa fa-globe"></i>地区管理
	</a>
</div>