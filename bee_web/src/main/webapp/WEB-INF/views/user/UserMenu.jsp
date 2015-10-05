<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">用户管理</span>
	<span>可查询、管理用户，设置用户VIP</span>
	<a id="navbar-inner-user-app" class="first" href="${basePath}/admin/user?type=<%=Consts.User.Type.AppUser %>">
		<i class="fa fa-star-o"></i>用户列表
	</a>
	<a id="navbar-inner-user-vip" href="${basePath}/admin/user?type=<%=Consts.User.Type.VipUser %>">
		<i class="fa fa-star"></i>VIP用户
	</a>
	<a id="navbar-inner-user-pink" href="${basePath}/admin/user?type=<%=Consts.User.Type.PinkUser %>">
		<i class="fa fa-female"></i>粉色用户
	</a>
	<a id="navbar-inner-user-buss" href="${basePath}/admin/user?type=<%=Consts.User.Type.BusiUser %>">
		<i class="fa fa-street-view"></i>商户管理员
	</a>
	<a id="navbar-inner-user-admin" href="${basePath}/admin/user?type=<%=Consts.User.Type.AdminUser %>">
		<i class="fa fa-user-secret"></i>系统管理员
	</a>
</div>