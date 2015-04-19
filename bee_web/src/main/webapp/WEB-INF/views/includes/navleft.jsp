<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$("#shopList").click(function(event) {
		window.location.href = "${basePath}/admin/shop";
	});
</script>

<div class="navbar-left">
	<ul>
		<li class="active"><i class="fa fa-home fa-lg"></i>首页</li>
		<li id="shopList"><i class="fa fa-university"></i>商家管理</li>
	</ul>
</div>