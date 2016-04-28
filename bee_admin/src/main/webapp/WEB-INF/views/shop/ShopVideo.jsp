<%@ page import="com.qsd.framework.security.annotation.Auth" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商家视频列表 - <spring:message code="application.name"/></title>

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
        <span class="before">商家视频列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">管理商家的视频</span>
    </div>
    <div id="content" class="row"></div>
    <script id="temp" type="text/html">
      <table class="table table-hover">
        <tr>
            <th>所属商家</th>
            <th>视频</th>
            <th>操作</th>
        </tr>
        {{if totalData < 1}}
          <tr>
            <td colspan="3" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 没有查到相关数据
            </td>
          </tr> 
        {{/if}}
        {{each result}}
        <tr>
          <td>{{$value.shop.name}}</td>
          <td>{{$value.hasVideo}}</td>
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
    Navbar.init("navbar-left-shop", "navbar-inner-shop-video");

    var indexPage = 1;

    var query = function() {
      Loader.show();
      $.getJSON("${basePath}/shop/0/video/json", {indexPage: indexPage}, function(data) {
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
      query();
    });

</script>
</body>
</html>