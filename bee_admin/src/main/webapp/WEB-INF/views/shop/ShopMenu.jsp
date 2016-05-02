<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">商户管理</span>
	<span>管理商户信息、价格和图片，统计商家流量信息</span>
	<a id="navbar-inner-shop-list" class="first" href="${basePath}/shop">
		<i class="fa fa-list fa-fw"></i>商户列表
	</a>
    <sec:security auth="<%=AuthName.ShopNew %>">
	<a id="navbar-inner-shop-new" href="${basePath}/shop/new">
		<i class="fa fa-plus fa-fw"></i>增加商户
	</a>
    </sec:security>
  
  <sec:security auth="<%=AuthName.ShopComment %>">
  <div class="line"></div>
 	<a id="navbar-inner-shop-comment" href="${basePath}/shop/0/comment" class="icon">
    <i class="fa fa-commenting-o fa-fw"></i>商家评论
  </a> 
  </sec:security>
  <a id="navbar-inner-shop-video" href="${basePath}/shop/0/video">
		<i class="fa fa-file-video-o fa-fw"></i>商家视频
	</a>
  <a id="navbar-inner-shop-image-view" href="${basePath}/shop/0/image/view">
		<i class="fa fa-picture-o fa-fw"></i>商家图片
	</a>
	<div class="line"></div>
	<sec:security auth="<%=AuthName.ShopApplyer %>">
	<a id="navbar-inner-shop-applyer" href="${basePath}/shop/applyer">
		<i class="fa fa-user-plus fa-fw"></i>商家申请
	</a>
	</sec:security>
</div>