<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<title>首页 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2iLGIOjXebTSNG6hiDmtEU9V"></script>
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
  		<form id="shopForm" class="form-horizontal" action="${basePath}/admin/shop" method="post">
  			<input type="hidden" name="_method" value="post" />
  			<input type="hidden" id="action" value="${action}" />
  			<input type="hidden" id="sid" name="sid" value="${shop.sid}" />
  			<input type="hidden" name="identity" value="${shop.identity}" />
  			<input type="hidden" name="status" value="${shop.status}" />
  			<input type="hidden" name="price" value="${shop.price}" />
  			<input type="hidden" name="createTime" value="${shop.createTime}" />
				<input type="hidden" name="focusNum" value="${shop.focusNum}" />

				<div class="form-group">
					<label class="col-xs-1 control-label">商家名称</label>
					<div class="col-xs-4">
						<input type="text" name="name" placeholder="商家名称" class="form-control" value="${shop.name}" />
					</div>
					<div class="col-xs-2 assist-label">
						<input type="checkbox" id="recommend" name="recommend" value="1" <c:if test="${shop.recommend == 1}">checked="checked"</c:if> /><label for="recommend">是否推荐</label>
					</div>
				</div>
				<div class="form-group">
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
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">联系电话</label>
					<div class="col-xs-4">
						<input type="text" name="phone" placeholder="手机号码" class="form-control" value="${shop.phone}" />
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
						<input type="text" name="addr" placeholder="商家地址" class="form-control" value="${shop.addr}" />
						<p class="help-block">仅需填写路名</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家地图</label>
					<div class="col-xs-4">
						<input type="text" id="shopGps" placeholder="商家地图GPS位置" class="form-control" readonly value="${shop.lon / 1E6},${shop.lat / 1E6}" />
						<p class="help-block">请在地图选择</p>
						<input type="hidden" id="shopLon" name="lon" value="${shop.lon}" />
						<input type="hidden" id="shopLat" name="lat" value="${shop.lat}" />
					</div>
					<div class="col-xs-2 assist-label">
						<button type="button" class="btn btn-primary icon-text" onclick="openMap()">
							<i class="fa fa-map-marker margin-right-5"></i>地图
						</button>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">排序</label>
					<div class="col-xs-4">
						<input type="text" name="sort" placeholder="100" class="form-control" value="${shop.sort}" />
						<p class="help-block">数字越大排名越靠前，默认100</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">排序有效期</label>
					<div class="col-xs-4">
						<input type="text" name="sortTime" placeholder="商家排序有效期" class="form-control" value="${shop.sortTime}" />
						<p class="help-block">设置有效期，到期后排序将恢复默认</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家介绍</label>
					<div class="col-xs-4">
						<div class="textarea">
							<textarea type="form-control" name="remark" rows="5">${shop.remark}</textarea>
						</div>
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
  	<div class="modal fade" id="mapModal" tabindex="-1" role="dialog" aria-labelledby="mapModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="mapModalLabel">地图</h4>
		      </div>
		      <div id="map" class="modal-body"></div>
		    </div>
		  </div>
		</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/map.js"></script>
  	<script type="text/javascript">
  		Navbar.init("ShopNew");
  		$("#area").area({
  			areaId: $("#areaId").val(),
  			initId: 1,
  			fn: function(r) {
  				$("#areaId").val(r);
  			}
  		});

  		function openMap() {
  			$("#mapModal > .modal-dialog").width("902px");
  			$("#map").css({overflow: "hidden", margin: "0"});
  			$("#mapModal").modal("show");
  			$("#map").map({
  				width: "900px",
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
	  			$("#shopGps").val(e.point.lng + "," + e.point.lat);
	  		});

  		}
  		
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