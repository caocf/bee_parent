<%@ page import="com.qsd.framework.security.annotation.Auth" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>商家图片预览 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="ShopMenu.jsp" %>
  	<div class="main inner">
		<div class="row title">
        <span class="before">商家图片预览</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">${shopName}</span>
      </div>
		<div class="row query-inner">
			<form id="queryForm" class="form-inline" action="${basePath}/shop/${sid}/image/view" method="get">
				<div class="form-group">
					<label>所属商家</label>
					<input type="text" id="shopName" class="form-control input-sm" value="${shopName}" />
				</div>
				<button type="submit" class="btn btn-primary btn-sm icon-text">
					<i class="fa fa-search"></i>查询
				</button>
			</form>
		</div>
		<div id="shopImageRow" class="row">
			<c:forEach items="${result}" var="image">
				<c:if test="${image.width > image.height}">
					<img class="lazy" data-original="${imagePath}${image.url}/thum.jpg" width="320" height="180" />
				</c:if>
				<c:if test="${image.width < image.height}">
					<img class="lazy" data-original="${imagePath}${image.url}/thum.jpg" width="180" height="320" />
				</c:if>
			</c:forEach>
		</div>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.lazyload.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
	<script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
	<script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
	<script type="text/javascript" src="${resPath}/assets/js/plugin/masonry/masonry.pkgd.min.js"></script>
  	<script type="text/javascript">
		Navbar.init("navbar-left-shop", "navbar-inner-shop-image-view");
		$("#shopName").click(function(event) {
			ShopSelectDialog.show(function(id, name) {
				$("#shopName").val(name);
				document.forms["queryForm"].action = "${basePath}/shop/" + id + "/image/view";
			});
		});
		$("img.lazy").lazyload({
			effect: "fadeIn",
			container: $("#shopImageRow")
		});
		$('#shopImageRow').masonry({
			itemSelector: '.lazy',
			columnWidth: 0
		});
  	</script>
	<%@ include file="../plugin/ShopSelectDialog.jsp" %>
  </body>
  </html>