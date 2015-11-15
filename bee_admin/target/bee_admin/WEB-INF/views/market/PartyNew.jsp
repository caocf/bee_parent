<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>添加活动 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/jquery.cxcalendar.css" rel="stylesheet">
	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=pTVc5RRuzyohGX50ToCGC3AG"></script>
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="MarketMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
  			<span class="before">添加活动</span>
  			<i class="fa fa-angle-double-right"></i>
  			<span class="after">添加一个活动</span>
  		</div>
  		<div class="row">
  			<div class="alert alert-danger <c:if test='${msg == null}'>hidden</c:if>" role="alert">${msg}</div>
  		</div>
  		<form id="submitForm" class="form-horizontal" action="${basePath}/admin/party" method="post" enctype="multipart/form-data">
  			<input type="hidden" name="party.pid" value="${party.pid}" />
  			<input type="hidden" name="party.createTime" value="${party.createTime}" />
  			<input type="hidden" name="party.lookNum" value="${party.lookNum}" />
  			<input type="hidden" name="party.type" value="${party.type}" />
  			<input type="hidden" name="party.childId" value="${party.childId}" />
  			<div class="form-group info-title">基本信息</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label">活动标题</label>
  				<div class="col-xs-4">
  					<input type="text" name="party.title" placeholder="活动标题" class="form-control" value="${party.title}" />
  				</div>
  				<div class="col-xs-2 assist-label">
						<input type="checkbox" id="isBee" name="party.isBee" value="1" <c:if test="${party.isBee == 1}">checked="checked"</c:if> /><label for="isBee">官方活动</label>
					</div>
  			</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label">排序</label>
  				<div class="col-xs-4">
  					<input type="text" name="party.sort" placeholder="列表顺序" class="form-control" value="${party.sort}" />
  					<p class="help-block">数字越大排名越靠前，默认100</p>
  				</div>
  			</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label">活动时间</label>
  				<div class="col-xs-10">
  					<input type="text" name="party.partyTime" placeholder="活动时间描述" class="form-control" value="${party.partyTime}" />
  				</div>
  			</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label">上线时间</label>
					<div class="col-xs-2">
						<input type="text" id="startTime" name="party.startTimeStr" placeholder="上架时间" class="form-control" value="${party.startTime}" data-position="bottom"/>
					</div>
					<div class="col-xs-2 margin-left-5">
						<input type="text" id="stopTime" name="party.stopTimeStr" placeholder="下架时间" class="form-control" value="${party.stopTime}" data-position="bottom"/>
					</div>
  			</div>
  			<div class="form-group info-title">活动图片</div>
  			<div class="form-group">
  				<div class="">
  					<button  id="btnImage" type="button" class="btn btn-primary icon-text">
  					<i class="fa fa-upload"></i>上传图片
  				</button>
  				</div>
  				<input type="file" id="file" name="file" />
  				<input type="hidden" name="party.path" value="${party.path}" />
  				<input type="hidden" name="party.url" value="${party.url}" />
  			</div>
  			<div class="form-group">
  				<div>
  					<img id="image" width="360px" height="183px" />
  				</div>
  			</div>
  			<div class="form-group info-title">线下活动</div>
  			<div class="form-group">
  				<input type="hidden" name="meet.pmid" vlaue="${meet.pmid}" />
  				<label class="col-xs-1 control-label">活动价格</label>	
  				<div class="col-xs-4">
  					<input type="text" name="meet.price" value="${meet.price}" placeholder="活动价格" class="form-control" />
  				</div>
  			</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label">活动说明</label>
  				<div class="col-xs-10">
  					<textarea name="meet.remark" class="form-control" rows="5">${meet.remark}</textarea>
  				</div>	
  			</div>
  			<div class="form-group info-title">地图选择</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label">活动地点</label>
					<div class="col-xs-10">
						<input type="text" name="meet.addr" class="form-control" placeholder="活动地点" value="${meet.addr}" />	
					</div>
  			</div>
				<div class="form-group">
					<input type="hidden" id="meetLon" name="meet.lon" value="${meet.lon}" />
					<input type="hidden" id="meetLat" name="meet.lat" value="${meet.lat}" />
					<div class="col-xs-10 col-xs-offset-1">
						<div id="map"></div>
					</div>
				</div>
  			<div class="form-group">
  				<label class="col-xs-1 control-label"></label>
  				<div class="col-xs-4">
  					<button type="button" class="btn btn-success submit" onclick="doSubmit();">保存</button>
  				</div>
  			</div>
  		</form>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/upload.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/cxcalendar/jquery.cxcalendar.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/map.js"></script>
  	<script type="text/javascript">
  		Navbar.init("navbar-left-marketing", "navbar-inner-market-party");
  		Upload.init("btnImage", "file", "image");
  		function doSubmit() {

  			document.forms[0].submit();
  		}
  		$(document).ready(function() {
  			var EApi;
				$("#startTime").cxCalendar({
  				startDate: new Date().getTime() - 86400000
  			});
				$("#stopTime").cxCalendar({
					startDate: $("#startTime").val(),
				}, function(api) {EApi = api});
				$("#stopTime").click(function(e) {
					EApi.setOptions({
						startDate: $("#startTime").val()
					});
				});

				$("#map").map({
  				height: "500px",
	  			gps: {
	  				show: true,
	  				lon: $("#meetLon").val() != "" ? $("#meetLon").val() / 1E6 : "",
	  				lat: $("#meetLat").val() != "" ? $("#meetLat").val() / 1E6 : ""
	  			},
	  			panoramaControl: true
	  		}).setEventListener("rightclick", function(e) {
	  			Map.addPoint({
	  				only: true,
	  				point: new BMap.Point(e.point.lng, e.point.lat)
	  			});
	  			$("#meetLon").val(e.point.lng * 1E6);
	  			$("#meetLat").val(e.point.lat * 1E6);
	  		});
  		});
  	</script>
  </body>
  </html>