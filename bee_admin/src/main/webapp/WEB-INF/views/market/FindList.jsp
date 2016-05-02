<%@ page import="com.qsd.framework.security.annotation.Auth" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>发现列表 - <spring:message code="application.name"/></title>

    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
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
        <span class="before">发现列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">管理发现列表</span>
    </div>
    <div id="content" class="row"></div>
    <script id="temp" type="text/html">
      <table class="table table-hover">
        <tr>
            <th>主键</th>
            <th>类型</th>
            <th>所属商家</th>
            <th width="40%">内容</th>
            <th>用户</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        {{each result}}
        <tr>
            <td>{{$value.fid}}</td>
            <td>{{$value.typeStr}}</td>
            <td>{{$value.shop.name}}</td>
            <td>{{$value.content}}</td>
            <td>{{$value.user.name}}</td>
            <td>{{$value.createTimeStr}}</td>
            <td>
              <sec:security auth="<%=AuthName.FindDelete%>">
              <a href="#" class="icon" role="button" onclick="deleteFind({{$value.fid}})">
                <i class="fa fa-trash font-color-red fa-lg"></i>
              </a> 
              </sec:security>
            </td>
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
    Navbar.init("navbar-left-marketing", "navbar-inner-market-find");
    var indexPage = 1;
    var query = function() {
      Loader.show();
      $.getJSON("${basePath}/find/json", {indexPage: indexPage}, function(data) {
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
    function deleteFind(fid) {
      $.post('${basePath}/find/' + fid, {_method: "delete"}, function(data, textStatus, xhr) {
        query(indexPage);
      });
    }
</script>
</body>
</html>