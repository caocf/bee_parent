<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商家技师 - <spring:message code="application.name"/></title>

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
        <span class="before">商家技师列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">${shopName}</span>
    </div>
    <div class="row query-inner">
        <sec:security auth="<%=AuthName.ShopTecheeNew %>">
        <a href="${basePath}/shop/${shopId}/group/${groupId}/techee/new" class="btn btn-primary icon-text" alt="增加技师">
            <i class="fa fa-plus font-color-white"></i>
            增加技师
        </a>
        </sec:security>
    </div>
    <div id="content" class="row"></div>
    <script id="temp" type="text/html">
      <table id="table" class="table table-hover">
        <tr>
            <th>主键</th>
            <th>所属分组</th>
            <th>技师编号</th>
            <th>是否出勤</th>
            <th>操作</th>
        </tr>
        {{if result.length < 1}}
          <tr>
            <td colspan="5" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 该商家还没有创建技师
            </td>
          </tr> 
        {{/if}}
        {{each result}}
        <tr>
            <td>{{$value.stId}}</td>
            <td>{{$value.shopGroup.groupName}}</td>
            <td>{{$value.number}}</td>
            <td>
                {{if $value.attend == 1}}是{{/if}}
                {{if $value.attend == 0}}否{{/if}}
            </td>
            <td>
                <sec:security auth="<%=AuthName.ShopCommentDelete%>">
                <a href="#" class="icon" role="button" onclick="deleteShopTechee(this, {{$value.stId}})">
                    <i class="fa fa-trash font-color-red fa-lg"></i>
                </a>
                </sec:security>
            </td>
        </tr>
        {{/each}}
      </table>
    </script>  
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/plugin/artTemplate/template.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript">
    Navbar.init("navbar-left-shop", "navbar-inner-shop-list");

    var query = function() {
      Loader.show();
      $.getJSON("${basePath}/shop/${shopId}/group/${groupId}/techee/json", function(data) {
        Loader.hide();
        $('#content').html(template('temp', data));
      });
    };

    $(document).ready(function() {
      query();
    });

    function deleteShopTechee(target, id) {
        Loader.show();
        $.post('${basePath}/shop/${shopId}/group/${groupId}/techee/' + id, 
            {_method: 'delete'}, function(data, textStatus, xhr) {
            Loader.hide();
            document.getElementById("table").deleteRow($(target).parent().parent().get(0).rowIndex);
        });
    }
</script>
</body>
</html>