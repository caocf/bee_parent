<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商家申请 - <spring:message code="application.name"/></title>

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
        <span class="before">商家申请列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">查看商家申请入驻信息</span>
    </div>
    <div id="content" class="row"></div>
    <script id="temp" type="text/html">
      <table class="table table-hover">
        <tr>
            <th>主键</th>
            <th>说明信息</th>
            <th>联系名</th>
            <th>联系电话</th>
            <th>申请时间</th>
        </tr>
        {{each result}}
        <tr>
            <td>{{$value.aid}}</td>
            <td>{{$value.extraInfo}}</td>
            <td>{{$value.linkName}}</td>
            <td>{{$value.phone}}</td>
            <td>{{$value.createTimeStr}}</td>
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
    Navbar.init("navbar-left-shop", "navbar-inner-shop-applyer");

    var indexPage = 1;

    var query = function() {
      Loader.show();
      $.getJSON("${basePath}/shop/applyer/json", {indexPage: indexPage}, function(data) {
        Loader.hide();
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
      });
    };

    $(document).ready(function() {
      query();
    });

</script>
</body>
</html>