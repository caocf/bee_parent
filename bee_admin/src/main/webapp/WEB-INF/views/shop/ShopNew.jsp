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
  		<form id="shopForm" class="form-horizontal" action="${basePath}/shop" method="post" enctype="multipart/form-data">
  			<input type="hidden" name="_method" value="post" />
  			<input type="hidden" id="action" value="${action}" />
  			<input type="hidden" id="sid" name="shop.sid" value="${shop.sid}" />
  			<input type="hidden" name="shop.identity" value="${shop.identity}" />
  			<input type="hidden" name="shop.status" value="${shop.status}" />
  			<input type="hidden" name="shop.price" value="${shop.price}" />
  			<input type="hidden" name="shop.createTime" value="${shop.createTime}" />
  			<input type="hidden" name="shop.isBack" value="${shop.isBack}" />
  			<input type="hidden" name="shop.updateTime" value="${shop.updateTime}" />
  			<input type="hidden" name="shop.phone" value="13162725286" />
  			<input type="hidden" name="shop.linkName" value="小黄蜂" />
				<div class="form-group info-title">基本信息</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家名称</label>
					<div class="col-xs-4">
						<input type="text" name="shop.name" placeholder="商家名称" class="form-control" value="${shop.name}" />
					</div>
					<div class="col-xs-1 assist-label">
						<input type="checkbox" id="recommend" name="shop.recommend" value="1" <c:if test="${shop.recommend == 1}">checked="checked"</c:if> /><label for="recommend">是否推荐</label>
					</div>
					<label class="col-xs-1 control-label">商家类型</label>
					<div class="col-xs-4">
						<select name="shop.type">
              <c:forEach items="<%= Consts.Shop.Type.Select() %>" var="type">
              <option value="${type.key}" <c:if test="${shop.type == type.key}">selected="selected"</c:if>>${type.value}</option>
              </c:forEach>
            </select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">接单开始</label>
					<div class="col-xs-4">
						<select name="startServiceTimeHour">
							<option value="12" <c:if test="${shop.startServiceTimeHour == 12}">selected="selected"</c:if>>12点</option>
							<option value="13" <c:if test="${shop.startServiceTimeHour == 13}">selected="selected"</c:if>>13点</option>
							<option value="14" <c:if test="${shop.startServiceTimeHour == 14}">selected="selected"</c:if>>14点</option>
							<option value="15" <c:if test="${shop.startServiceTimeHour == 15}">selected="selected"</c:if>>15点</option>
							<option value="16" <c:if test="${shop.startServiceTimeHour == 16}">selected="selected"</c:if>>16点</option>
							<option value="17" <c:if test="${shop.startServiceTimeHour == 17}">selected="selected"</c:if>>17点</option>
							<option value="18" <c:if test="${shop.startServiceTimeHour == 18}">selected="selected"</c:if>>18点</option>
							<option value="19" <c:if test="${shop.startServiceTimeHour == 19}">selected="selected"</c:if>>19点</option>
							<option value="20" <c:if test="${shop.startServiceTimeHour == 20}">selected="selected"</c:if>>20点</option>
							<option value="21" <c:if test="${shop.startServiceTimeHour == 21}">selected="selected"</c:if>>21点</option>
							<option value="22" <c:if test="${shop.startServiceTimeHour == 22}">selected="selected"</c:if>>22点</option>
							<option value="23" <c:if test="${shop.startServiceTimeHour == 23}">selected="selected"</c:if>>23点</option>
							<option value="0" <c:if test="${shop.startServiceTimeHour == 0}">selected="selected"</c:if>>0点</option>
							<option value="1" <c:if test="${shop.startServiceTimeHour == 1}">selected="selected"</c:if>>1点</option>
							<option value="2" <c:if test="${shop.startServiceTimeHour == 2}">selected="selected"</c:if>>2点</option>
							<option value="3" <c:if test="${shop.startServiceTimeHour == 3}">selected="selected"</c:if>>3点</option>
							<option value="4" <c:if test="${shop.startServiceTimeHour == 4}">selected="selected"</c:if>>4点</option>
							<option value="5" <c:if test="${shop.startServiceTimeHour == 5}">selected="selected"</c:if>>5点</option>
							<option value="6" <c:if test="${shop.startServiceTimeHour == 6}">selected="selected"</c:if>>6点</option>
							<option value="7" <c:if test="${shop.startServiceTimeHour == 7}">selected="selected"</c:if>>7点</option>
							<option value="8" <c:if test="${shop.startServiceTimeHour == 8}">selected="selected"</c:if>>8点</option>
							<option value="9" <c:if test="${shop.startServiceTimeHour == 9}">selected="selected"</c:if>>9点</option>
							<option value="10" <c:if test="${shop.startServiceTimeHour == 10}">selected="selected"</c:if>>10点</option>
							<option value="11" <c:if test="${shop.startServiceTimeHour == 11}">selected="selected"</c:if>>11点</option>
						</select>
						<select name="startServiceTimeMinute">
							<option value="0" <c:if test="${shop.startServiceTimeMinute == 0}">selected="selected"</c:if>>0分</option>
							<option value="15" <c:if test="${shop.startServiceTimeMinute == 15}">selected="selected"</c:if>>15分</option>
							<option value="30" <c:if test="${shop.startServiceTimeMinute == 30}">selected="selected"</c:if>>30分</option>
							<option value="45" <c:if test="${shop.startServiceTimeMinute == 45}">selected="selected"</c:if>>45分</option>
						</select>
					</div>
					<label class="col-xs-2 control-label">接单结束</label>
					<div class="col-xs-4">
						<select name="endServiceTimeHour">
							<option value="0" <c:if test="${shop.endServiceTimeHour == 0}">selected="selected"</c:if>>0点</option>
							<option value="1" <c:if test="${shop.endServiceTimeHour == 1}">selected="selected"</c:if>>1点</option>
							<option value="2" <c:if test="${shop.endServiceTimeHour == 2}">selected="selected"</c:if>>2点</option>
							<option value="3" <c:if test="${shop.endServiceTimeHour == 3}">selected="selected"</c:if>>3点</option>
							<option value="4" <c:if test="${shop.endServiceTimeHour == 4}">selected="selected"</c:if>>4点</option>
							<option value="5" <c:if test="${shop.endServiceTimeHour == 5}">selected="selected"</c:if>>5点</option>
							<option value="6" <c:if test="${shop.endServiceTimeHour == 6}">selected="selected"</c:if>>6点</option>
							<option value="7" <c:if test="${shop.endServiceTimeHour == 7}">selected="selected"</c:if>>7点</option>
							<option value="8" <c:if test="${shop.endServiceTimeHour == 8}">selected="selected"</c:if>>8点</option>
							<option value="9" <c:if test="${shop.endServiceTimeHour == 9}">selected="selected"</c:if>>9点</option>
							<option value="10" <c:if test="${shop.endServiceTimeHour == 10}">selected="selected"</c:if>>10点</option>
							<option value="11" <c:if test="${shop.endServiceTimeHour == 11}">selected="selected"</c:if>>11点</option>
							<option value="12" <c:if test="${shop.endServiceTimeHour == 12}">selected="selected"</c:if>>12点</option>
							<option value="13" <c:if test="${shop.endServiceTimeHour == 13}">selected="selected"</c:if>>13点</option>
							<option value="14" <c:if test="${shop.endServiceTimeHour == 14}">selected="selected"</c:if>>14点</option>
							<option value="15" <c:if test="${shop.endServiceTimeHour == 15}">selected="selected"</c:if>>15点</option>
							<option value="16" <c:if test="${shop.endServiceTimeHour == 16}">selected="selected"</c:if>>16点</option>
							<option value="17" <c:if test="${shop.endServiceTimeHour == 17}">selected="selected"</c:if>>17点</option>
							<option value="18" <c:if test="${shop.endServiceTimeHour == 18}">selected="selected"</c:if>>18点</option>
							<option value="19" <c:if test="${shop.endServiceTimeHour == 19}">selected="selected"</c:if>>19点</option>
							<option value="20" <c:if test="${shop.endServiceTimeHour == 20}">selected="selected"</c:if>>20点</option>
							<option value="21" <c:if test="${shop.endServiceTimeHour == 21}">selected="selected"</c:if>>21点</option>
							<option value="22" <c:if test="${shop.endServiceTimeHour == 22}">selected="selected"</c:if>>22点</option>
							<option value="23" <c:if test="${shop.endServiceTimeHour == 23}">selected="selected"</c:if>>23点</option>
						</select>
						<select name="endServiceTimeMinute">
							<option value="0" <c:if test="${shop.endServiceTimeMinute == 0}">selected="selected"</c:if>>0分</option>
							<option value="15" <c:if test="${shop.endServiceTimeMinute == 15}">selected="selected"</c:if>>15分</option>
							<option value="30" <c:if test="${shop.endServiceTimeMinute == 30}">selected="selected"</c:if>>30分</option>
							<option value="45" <c:if test="${shop.endServiceTimeMinute == 45}">selected="selected"</c:if>>45分</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">排序</label>
					<div class="col-xs-4">
						<input type="text" name="shop.sort" placeholder="100" class="form-control" value="${shop.sort}" />
						<p class="help-block">数字越大排名越靠前，默认100</p>
					</div>
					<label class="col-xs-2 control-label">排序有效期</label>
					<div class="col-xs-4">
						<input type="text" id="sortTime" name="sortTimeText" placeholder="商家排序有效期" class="form-control" value="${shop.sortTimeStr}" data-position="bottom" />
						<p class="help-block">设置有效期，到期后排序将恢复默认</p>
					</div>
				</div>
				<div class="form-group hide">
					<label class="col-xs-1 control-label">商家介绍</label>
					<div class="col-xs-10">
						<div class="textarea">
							<textarea type="form-control" name="shop.remark" rows="5">${shop.remark}</textarea>
						</div>
					</div>
				</div>
				<div class="form-group info-title">商家图片</div>
				<div class="form-group">
                    <button  id="btnThum" type="button" class="btn btn-primary icon-text">
                        <i class="fa fa-upload"></i>上传缩略图
                    </button>
                    <input type="file" id="thumbnailFile" name="thumbnailFile" />
					<button  id="btnImage" type="button" class="btn btn-primary icon-text">
    				    <i class="fa fa-upload"></i>上传主图
    			    </button>
    			    <input type="file" id="file" name="file" />
  				    <button  id="btnRecommendImage" type="button" class="btn btn-primary icon-text">
    				    <i class="fa fa-upload"></i>上传推广图
    			    </button>
    			    <input type="file" id="recommendFile" name="recommendFile" />
				</div>
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
					<input type="hidden" id="areaId" name="shop.area.aid" value="${shop.area.aid}" />
					<div id="area" class="col-xs-10"></div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">商家地址</label>
					<div class="col-xs-10">
						<input type="text" name="shop.addr" placeholder="仅需填写路名" class="form-control" value="${shop.addr}" />
					</div>
				</div>
				<div class="form-group">
					<input type="hidden" id="shopLon" name="shop.lon" value="${shop.lon}" />
					<input type="hidden" id="shopLat" name="shop.lat" value="${shop.lat}" />
					<div class="col-xs-10 col-xs-offset-1">
						<div id="map" style="hight:500px;"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label"></label>
					<div class="col-xs-4">
						<button type="button" class="btn btn-success" onclick="doSubmit();">
							<c:if test="${action == 'new'}">创建</c:if>
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
  		Navbar.init("navbar-left-shop", "navbar-inner-shop-new");
  		Upload.init("btnThum", "thumbnailFile", "thumbnailImage");
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
                document.forms["shopForm"].action = "${basePath}/shop/" + $("#sid").val();
                document.getElementsByName("_method")[0].value = "put";
            }
            document.forms["shopForm"].submit();
        }
  	</script>
  </body>
  </html>