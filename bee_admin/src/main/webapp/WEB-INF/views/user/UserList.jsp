<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户列表 - <spring:message code="application.name"/></title>

	<link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="shop">
  	<%@ include file="../includes/navtop.jsp" %>
  	<%@ include file="../includes/navleft.jsp" %>
  	<%@ include file="UserMenu.jsp" %>
  	<div class="main inner">
  		<div class="row title">
        <span class="before">用户列表</span>
        <i class="fa fa-angle-double-right"></i>  
        <span class="after">管理用户信息列表</span>
      </div>
      <div class="row query-inner">
        <form id="queryForm" class="form-inline" method="get">
          <input type="hidden" id="type" value="${params.type}" />
          <div class="form-group">
            <label>手机号</label>
            <input type="text" id="phone" class="form-control input-sm" />
          </div>
          <div class="form-group">
            <label>用户昵称</label>
            <input type="text" id="userName" class="form-control input-sm" />
          </div>
          <div class="form-group">
            <label>积分</label>
            <input type="text" id="integral" class="form-control input-sm" />
          </div>
          <button type="button" class="btn btn-primary btn-sm icon-text" onclick="query()">
            <i class="fa fa-search"></i>查询
          </button>
        </form>
      </div>
      <div id="content" class="row"></div>
      <script id="temp" type="text/html">
        <table class="table table-hover">
          <tr>
            <th>主键</th>
            <th>手机号</th>
            <th>昵称</th>
            <th>等级</th>
            <th>积分</th>
            <th>加入时间</th>
            <th>操作</th>
          </tr>
          {{if totalData < 1}}
            <tr>
              <td colspan="7" class="text-center">
                <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 没有查询到相关数据
              </td>
            </tr> 
          {{/if}}
          {{each result}}
            <tr>
              <td>{{$value.uid}}</td>
              <td>{{$value.phone}}</td>
              <td>{{$value.name}}</td>
              <td>{{$value.level}}</td>
              <td>{{$value.integral}}</td>
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
  		Navbar.init("navbar-left-user", "${params.pageType}");

      var indexPage = 1;

      var query = function() {
        Loader.show();
        $.getJSON("${basePath}/user/json", 
          {indexPage: indexPage, 
            phone: $("#phone").val(), 
            userName: $("#userName").val(),
            type: $("#type").val(),
            integral: $("#integral").val()},
            function(data) {
          $('#content').html(template('temp', data));
          $("#paging").paging({
            index: data.indexPage,
            total: data.totalPage,
            count: data.totalData,
            fn : function(r) {
              indexPage = r;
              query();
            }
          });
          Loader.hide();
        });
      };

      $(document).ready(function() {
        query();
      });
  	</script>
  </body>
  </html>