<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>App版本管理 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="shop">
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="SystemMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">App版本列表</span>
        <i class="fa fa-angle-double-right"></i>	
  			<span class="after">查看App版本列表</span>
      </div>
      <div id="content" class="row"></div>
      <script id="temp" type="text/html">
        <table class="table table-hover">
          <tr>
            <th>主键</th>
            <th>版本类型</th>
            <th>版本号</th>
            <th>版本码</th>
            <th>发布日期</th>
            <th>操作</th>
          </tr>
          {{each result}}
            <tr>
              <td>{{$value.avid}}</td>
              <td>{{$value.typeStr}}</td>
              <td>{{$value.verStr}}</td>
              <td>{{$value.ver}}</td>
              <td>{{$value.createTimeStr}}</td>
              <td></td>
            </tr>
          {{/each}} 
        </table>
      </script>
      <div id="paging" class="row"></div>
  	</div>
  	<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/artTemplate/template.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  	<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
  	<script type="text/javascript">
  		Navbar.init("navbar-left-system", "navbar-inner-system-app");
      
      var indexPage = 1;

      var query = function() {
        Loader.show();
        $.getJSON("${basePath}/appver/json", {indexPage: indexPage}, function(data) {
            $('#content').html(template('temp', data));
            $("#paging").paging({
              index: data.indexPage,
              total: data.totalPage,
              count: data.totalData,
              fn : function(r) {
                indexPage = r;
                query(r);
              }
            });
            Loader.hide();
        });
      };

      $(document).ready(function() {
        query(indexPage);
      });
  	</script>
  </body>
  </html>