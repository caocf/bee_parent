<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>商家价格列表 - <spring:message code="application.name"/></title>

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
        <span class="before">商家价格列表</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">${shop.name}</span>
      </div>
      <div class="row query-inner">
        <a href="${basePath}/admin/shop/${sid}/price/new" class="btn btn-primary icon-text">
          <i class="fa fa-plus font-color-white"></i>增加价格
        </a>
      </div>
    	<form:form id="delForm" method="delete"></form:form>
     	<table class="table table-hover">
      	<tr>
      		<th>主键</th>
      		<th>说明</th>
      		<th>价格</th>
      		<th>排序</th>
      		<th>操作</th>
      	</tr>
      	<c:forEach items="${result}" var="price">
	      	<tr>
	      		<td>${price.spid}</td>
	      		<td>${price.mark}</td>
	      		<td>${price.price}</td>
	      		<td>${price.sort}</td>
	      		<td>
	      			<a href="${basePath}/admin/shop/${sid}/price/${price.spid}/edit" class="icon" role="button">
                <i class="fa fa-pencil font-color-base fa-lg"></i>
              </a>
      				<a href="#" class="icon" role="button" onclick="deleteImage(${price.spid})">
                <i class="fa fa-trash font-color-red fa-lg"></i>
              </a>
	      		</td>
	      	</tr>
      	</c:forEach>
      </table> 
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript">
  		Navbar.init("ShopPrice");
  		function deleteImage(id) {
  			document.forms['delForm'].action = "${basePath}/admin/shop/${sid}/price/" + id;
  			document.forms['delForm'].submit();
  		}
  	</script>
  </body>
  </html>