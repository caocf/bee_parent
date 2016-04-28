<%@ page import="com.qsd.framework.security.annotation.Auth" %>
<%@ page import="com.bee.pojo.shop.ShopComment" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商家评论列表 - <spring:message code="application.name"/></title>

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
        <span class="before">商家评论列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">管理商家的评论</span>
    </div>
    <c:if test="${shopId > 0}">
    <div class="row query-inner">
        <sec:security auth="<%=AuthName.ShopCommentNew %>">
        <button id="shopCommentNew" type="button" class="btn btn-success btn-sm icon-text" onclick="addComment()">
          <i class="fa fa-plus"></i>增加评论
        </button>
        </sec:security>
    </div>
    </c:if>
    <div id="content" class="row"></div>
    <script id="temp" type="text/html">
      <table class="table table-hover">
        <tr>
            <th>主键</th>
            <c:if test="${shopId < 1}">
              <th>所属商家</th>
            </c:if>
            <th>用户</th>
            <th>评论内容</th>
            <th class="text-center">回复数</th>
            <th>评论时间</th>
            <th>操作</th>
        </tr>
        {{if totalData < 1}}
          <tr>
            <td colspan="7" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 该商家还没有评论
            </td>
          </tr> 
        {{/if}}
        {{each result}}
        <tr>
            <td>{{$value.scid}}</td>
            <c:if test="${shopId < 1}">
              <td>{{$value.shop.name}}</td>
            </c:if>
            <td>{{$value.user.name}}</td>
            <td width="40%">{{$value.content}}</td>
            <td class="text-center">
              <a href="#" onclick="queryReply({{$value.scid}})">{{$value.replyNum}}</a>
            </td>
            <td>{{$value.createTimeStr}}</td>
            <td>
                <sec:security auth="<%=AuthName.ShopCommentDelete%>">
                <a href="#" class="icon" role="button" onclick="deleteComment({{$value.shop.sid}}, {{$value.scid}})">
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
    Navbar.init("navbar-left-shop", "navbar-inner-shop-comment");

    var indexPage = 1;

    var query = function() {
      Loader.show();
      $.getJSON("${basePath}/shop/${shopId}/comment/json", {indexPage: indexPage}, function(data) {
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

    var deleteComment = function(shopId, id) {
      $.post('${basePath}/shop/' + shopId + '/comment/' + id, {_method: "delete"}, function(data, textStatus, xhr) {
        query(indexPage);
      });
    };

    $(document).ready(function() {
      query(indexPage);
    });


    function addComment() {
      window.location.href = "${basePath}/shop/${shopId}/comment/new?shopName=${shopName}";
    }

    function queryReply(id) {
      window.location.href = "${basePath}/shop/${shopId}/comment/" + id + "/reply";
    }
</script>
</body>
</html>