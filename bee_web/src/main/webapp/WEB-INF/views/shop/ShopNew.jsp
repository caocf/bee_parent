<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta name="robots" content="noindex,nofollow">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<title>首页 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/jquery.cxcalendar.css" rel="stylesheet" />
	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet" />
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=pTVc5RRuzyohGX50ToCGC3AG"></script>
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
  		<form id="shopForm" class="form-horizontal" action="${basePath}/admin/shop" method="post" enctype="multipart/form-data">
  			<input type="hidden" name="_method" value="post" />
  			<input type="hidden" id="action" value="${action}" />
  			<input type="hidden" id="sid" name="sid" value="${shop.sid}" />
  			<input type="hidden" name="identity" value="${shop.identity}" />
  			<input type="hidden" name="status" value="${shop.status}" />
  			<input type="hidden" name="price" value="${shop.price}" />
  			<input type="hidden" name="createTime" value="${shop.createTime}" />
  			<input type="hidden" name="isBack" value="${shop.isBack}" />
				<div class="form-group info-title">基本信息</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家名称</label>
					<div class="col-xs-4">
						<input type="text" name="name" placeholder="商家名称" class="form-control" value="${shop.name}" />
					</div>
					<div class="col-xs-1 assist-label">
						<input type="checkbox" id="recommend" name="recommend" value="1" <c:if test="${shop.recommend == 1}">checked="checked"</c:if> /><label for="recommend">是否推荐</label>
					</div>
					<label class="col-xs-1 control-label">商家类型</label>
					<div class="col-xs-4">
						<select name="type">
              <c:forEach items="<%= Consts.Shop.Type.Select() %>" var="type">
              <option value="${type.key}" <c:if test="${shop.type == type.key}">selected="selected"</c:if>>${type.value}</option>
              </c:forEach>
            </select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">联系人</label>
					<div class="col-xs-4">
						<input type="text" name="linkName" placeholder="商家联系人" class="form-control" maxlength="11" value="${shop.linkName}" />
					</div>
					<label class="col-xs-2 control-label">联系电话</label>
					<div class="col-xs-4">
						<input type="text" name="phone" placeholder="手机号码" class="form-control" value="${shop.phone}" maxlength="11" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">排序</label>
					<div class="col-xs-4">
						<input type="text" name="sort" placeholder="100" class="form-control" value="${shop.sort}" />
						<p class="help-block">数字越大排名越靠前，默认100</p>
					</div>
					<label class="col-xs-2 control-label">排序有效期</label>
					<div class="col-xs-4">
						<input type="text" id="sortTime" name="sortTime" placeholder="商家排序有效期" class="form-control" value="${shop.sortTime}" data-position="bottom" />
						<p class="help-block">设置有效期，到期后排序将恢复默认</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家介绍</label>
					<div class="col-xs-10">
						<div class="textarea">
							<textarea type="form-control" name="remark" rows="5">${shop.remark}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group info-title">商家图片</div>
				<div class="form-group">
					<button  id="btnImage" type="button" class="btn btn-primary icon-text">
    				<i class="fa fa-upload"></i>上传主图
    			</button>
    			<input type="file" id="file" name="file" />
  				<input type="hidden" name="image.iid" value="${shop.image.iid}" />
  				<button  id="btnRecommendImage" type="button" class="btn btn-primary icon-text">
    				<i class="fa fa-upload"></i>上传推广图
    			</button>
    			<input type="file" id="recommendFile" name="recommendFile" />
  				<input type="hidden" name="recommendImage.iid" value="${shop.recommendImage.iid}" />
				</div>
				<div class="form-group">
  				<div>
  					<img id="image" width="188px" height="115px" <c:if test="${shop.image.iid != 0}"> src="${basePath}${shop.image.url}/p_750x460.jpg"</c:if> />
  					<img id="recommendImage" width="108px" height="150px" <c:if test="${shop.recommendImage.iid != 0}"> src="${basePath}${shop.recommendImage.url}/p_215x300.jpg"</c:if> />
  				</div>
  			</div>
				<div class="form-group info-title">地图选择</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">所属地区</label>
					<input type="hidden" id="areaId" name="area.aid" value="${shop.area.aid}" />
					<div id="area" class="col-xs-10"></div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家地址</label>
					<div class="col-xs-10">
						<input type="text" name="addr" placeholder="仅需填写路名" class="form-control" value="${shop.addr}" />
					</div>
				</div>
				<div class="form-group">
					<input type="hidden" id="shopLon" name="lon" value="${shop.lon}" />
					<input type="hidden" id="shopLat" name="lat" value="${shop.lat}" />
					<div class="col-xs-10 col-xs-offset-1">
						<div id="map" style="hight:500px;"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label"></label>
					<div class="col-xs-4">
						<button type="button" class="btn btn-success" onclick="doSubmit();">
							<c:if test="${action == 'new'}">下一步</c:if>
							<c:if test="${action == 'edit'}">保存</c:if>
						</button>
					</div>
				</div>
  		</form>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/upload.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/map.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/cxcalendar/jquery.cxcalendar.min.js"></script>
  	<script type="text/javascript">
  		Navbar.init("ShopNew");
  		Upload.init("btnImage", "file", "image");
  		Upload.init("btnRecommendImage", "recommendFile", "recommendImage");
  		$("#area").area({
  			areaId: $("#areaId").val(),
  			initId: 1,
  			fn: function(r) {
  				$("#areaId").val(r);
  			}
  		});

  		$("#sortTime").cxCalendar({
  			startDate: new Date().getTime() - 86400000
  		});

  		$("#map").map({
  				height: "500px",
	  			gps: {
	  				show: true,
	  				lon: $("#shopLon").val() != "" ? $("#shopLon").val() / 1E6 : "",
	  				lat: $("#shopLat").val() != "" ? $("#shopLat").val() / 1E6 : ""
	  			},
	  			scrollWheelZoom: true
	  		}).setEventListener("rightclick", function(e) {
	  			Map.addPoint({
	  				only: true,
	  				point: new BMap.Point(e.point.lng, e.point.lat)
	  			});
	  			$("#shopLon").val(e.point.lng * 1E6);
	  			$("#shopLat").val(e.point.lat * 1E6);
	  		});
  		
        function doSubmit() {
            if($("#action").val() == "edit") {
                document.forms["shopForm"].action = "${basePath}/admin/shop/" + $("#sid").val();
                document.getElementsByName("_method")[0].value = "put";
            }
            document.forms["shopForm"].submit();
        }
  	</script>
  </body>
  </html>