<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${shop.name} - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="shop">
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="ShopMenu.jsp" %>
  	<div class="main inner">
      <div class="row title">
        <span class="before">商家详情</span>
        <i class="fa fa-angle-double-right"></i>  
        <span class="after">查看商家的详细信息</span>
      </div>
      <div class="row query-inner">
        <a href="${basePath}/shop/${shop.sid}/edit" class="btn btn-primary icon-text" alt="修改">
            <i class="fa fa-pencil font-color-white"></i>修改
        </a>
    </div>
      <form class="form-horizontal">	
      <div class="form-group info-title">基本信息</div>	
      <div class="form-group">
        <label class="col-xs-1 control-label">商家名称</label>
        <div class="col-xs-4 assist-label">${shop.name}</div>
        <label class="col-xs-2 control-label">商家类型</label>
        <div class="col-xs-4 assist-label">${shop.typeStr}</div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">接单开始</label>
        <div class="col-xs-4 assist-label">${shop.startServiceTimeHour}:${shop.startServiceTimeMinute}</div> 
        <label class="col-xs-2 control-label">接单结束</label> 
        <div class="col-xs-4 assist-label">${shop.endServiceTimeHour}:${shop.endServiceTimeMinute}</div>
      </div> 
      <div class="form-group">
        <label class="col-xs-1 control-label">排序</label>
        <div class="col-xs-4 assist-label">${shop.sort}</div>
        <label class="col-xs-2 control-label">排序有效期</label>
        <div class="col-xs-4 assist-label">${shop.sortTimeStr}</div>
      </div>
      <div class="form-group info-title">商家图片</div>
      <div class="form-group">
        <div>
          <img id="thumbnailImage" width="160px" height="160px" src="${imagePath}/static/shop/shop_${shop.sid }/thumbnail_720.jpg" />
          <img id="image" width="188px" height="115px" src="${imagePath}/static/shop/shop_${shop.sid }/face_720.jpg" />
          <img id="recommendImage" width="108px" height="150px" src="${imagePath}/static/shop/shop_${shop.sid }/recommend_720.jpg"/>
        </div>
      </div>
      <div class="form-group info-title">地图选择</div>
      <div class="form-group">
        <label class="col-xs-1 control-label">所属地区</label>
        <div class="col-xs-10 assist-label">${shop.area.name}</div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">商家地址</label>
        <div class="col-xs-10 assist-label">${shop.addr}</div>
      </div>
    </form>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript">
  	 Navbar.init("navbar-left-shop", "navbar-inner-shop-list");
    </script>
  </body>
  </html>