<%@ page language="java" pageEncoding="UTF-8"%>

<div class="navbar-inner">
	<span class="title">用户管理</span>
	<span>可查询、管理用户信息</span>
	<a id="navbar-inner-user-app" class="first" href="${basePath}/user?type=<%=Consts.User.Type.AppUser %>">
		<i class="fa fa-star-o fa-fw"></i>用户列表
	</a>
	<a id="navbar-inner-user-vip" href="${basePath}/user?type=<%=Consts.User.Type.VipUser %>">
		<i class="fa fa-star fa-fw"></i>VIP用户
	</a>
    <a id="navbar-inner-user-test" href="${basePath}/user?type=<%=Consts.User.Type.TestUser %>">
        <i class="fa fa-star-half-o fa-fw"></i>测试帐号
    </a>
    <%--
	<a id="navbar-inner-user-pink" href="${basePath}/user?type=<%=Consts.User.Type.PinkUser %>">
		<i class="fa fa-female"></i>粉色用户
	</a>
	--%>
	<a id="navbar-inner-user-buss" href="${basePath}/user?type=<%=Consts.User.Type.BusiUser %>">
		<i class="fa fa-street-view fa-fw"></i>商户管理员
	</a>
    <sec:security auth="<%=AuthName.SuperAdmin%>">
	<a id="navbar-inner-user-admin" href="${basePath}/user?type=<%=Consts.User.Type.AdminUser %>">
		<i class="fa fa-user-secret fa-fw"></i>系统管理员
	</a>
    </sec:security>
    <div class="line"></div>
    <a id="navbar-inner-user-advice" href="${basePath}/advice">
		<i class="fa fa-exclamation-triangle fa-fw"></i>用户建议
	</a>
</div>