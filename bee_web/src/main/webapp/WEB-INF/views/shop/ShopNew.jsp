<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>首页 - 大黄蜂后台管理系统</title>

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
  			<span class="before">增加商户</span>
  			<i class="fa fa-angle-double-right"></i>	
  			<span class="after">添加一个商户信息</span>
  		</div>
  		<div class="row">
  			<div class="alert alert-danger <c:if test="${msg != ''}">hidden</c:if>" role="alert">${msg}</div>
  		</div>
  		<form class="form-horizontal" action="${basePath}/admin/shop" method="post">
				<div class="form-group">
					<label class="col-xs-1 control-label">商家名称</label>
					<div class="col-xs-4">
						<input type="text" name="name" placeholder="商家名称" class="form-control" />
					</div>
					<div class="col-xs-2 assist-label">
						<input type="checkbox" id="recommend" name="recommend" value="1" /><label for="recommend">是否推荐</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家类型</label>
					<div class="col-xs-4">
						<select name="type">
              <c:forEach items="<%= Consts.Shop.Type.Select() %>" var="type">
                <option value="${type.key}">${type.value}</option>
              </c:forEach>
            </select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">联系人</label>
					<div class="col-xs-4">
						<input type="text" name="linkName" placeholder="商家联系人" class="form-control" maxlength="11" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">联系电话</label>
					<div class="col-xs-4">
						<input type="text" name="phone" placeholder="手机号码" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">所属地区</label>
					<input type="hidden" id="areaId" name="area.aid" value="${shop.area.aid}" />
					<div id="area" class="col-xs-4"></div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家地址</label>
					<div class="col-xs-4">
						<input type="text" name="addr" placeholder="商家地址" class="form-control" />
						<p class="help-block">仅需填写路名</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家地图</label>
					<div class="col-xs-4">
						<input type="text" id="shopGps" placeholder="商家地图GPS位置" class="form-control" readonly />
						<p class="help-block">请在地图选择</p>
						<input type="hidden" id="shopLon" name="lon" />
						<input type="hidden" id="shopLat" name="lat" />
					</div>
					<div class="col-xs-2 assist-label">
						<button type="submit" class="btn btn-primary icon-text">
							<i class="fa fa-map-marker margin-right-5"></i>地图
						</button>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家介绍</label>
					<div class="col-xs-4">
						<div class="textarea">
							<textarea type="form-control" name="remark" rows="5"></textarea>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label"></label>
					<div class="col-xs-4">
						<button type="submit" class="btn btn-success">下一步</button>
					</div>
				</div>
  		</form>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
  	<script type="text/javascript">
  		Navbar.init("ShopNew");
  		$("#area").area({
  			areaId: $("#areaId").val(),
  			initId: 1,
  			fn: function(r) {
  				$("#areaId").val(r);
  			}
  		});	
  	</script>
  </body>
  </html>