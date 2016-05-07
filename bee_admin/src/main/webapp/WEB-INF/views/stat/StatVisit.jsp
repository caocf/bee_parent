<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户统计 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="StatMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">用户统计</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">查看用户登录和注册统计表</span>
      </div>
      <div id="VisitChart" class="chart"></div>
      <div id="Visit24Chart" class="chart"></div>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/json2.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/plugin/echarts/echarts.min.js"></script>
  	
    <script type="text/javascript">
  		Navbar.init("navbar-left-stat", "navbar-inner-stat-visit");
      var chart = echarts.init(document.getElementById('VisitChart'));
      chart.showLoading();
      $.get(BasePath + "/stat/visit/chart", function(data) {
        chart.hideLoading();
        chart.setOption(JSON.parse(data));
        chart.on("click", function(param) {
          showLoginDetail(param.name);
        });
      });

      var dChart = echarts.init(document.getElementById('Visit24Chart'));
      function showLoginDetail(name) {
        dChart.showLoading();
        $.get(BasePath + "/stat/visit/detail?name="+name, function(data) {
          dChart.hideLoading();
          dChart.clear();
          dChart.setOption(JSON.parse(data));
        });
      }

  	</script>
  </body>
  </html>