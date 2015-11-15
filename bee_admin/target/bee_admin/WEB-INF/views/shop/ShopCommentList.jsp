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
    <div class="row query-inner">
      <form id="queryForm" class="form-inline" action="${basePath}/shop/${params.shopId}/comment" method="get">
          <input type="hidden" name="indexPage" id="indexPage" value="${result.indexPage}" />
          <div class="form-group">
            <label>所属商家</label>
            <input type="text" id="shopName" name="shopName" class="form-control input-sm" value="${params.shopName}" />
          </div>
          <button type="submit" class="btn btn-primary btn-sm icon-text">
            <i class="fa fa-search"></i>查询
          </button>
          <sec:security auth="<%=AuthName.ShopCommentNew %>">
          <button id="shopCommentNew" type="button" class="btn btn-success btn-sm icon-text" onclick="addComment()">
            <i class="fa fa-plus"></i>增加
          </button>
          </sec:security>
      </form>
    </div>
    <form:form id="delForm" method="delete"></form:form>
    <c:if test="${params.shopId > 0}">
    <table class="table table-hover">
        <tr>
            <th>主键</th>
            <th>评论内容</th>
            <th>用户</th>
            <th>评论时间</th>
            <th>操作</th>
        </tr>
        <c:if test="${result.totalData < 1}">
          <tr>
            <td colspan="6" class="text-center">
              <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 该商家还没有评论
            </td>
          </tr> 
        </c:if>
        <c:forEach items="${result.data}" var="comments">
            <tr>
                <td>${comments.scid}</td>
                <td>${comments.content}</td>
                <td>${comments.user.name}</td>
                <td>${comments.createTimeStr}</td>
                <td>
                    <sec:security auth="<%=AuthName.ShopCommentDelete%>">
                    <a href="#" class="icon" role="button" onclick="deleteImage(${comments.scid})">
                        <i class="fa fa-trash font-color-red fa-lg"></i>
                    </a>
                    </sec:security>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div id="paging" class="row"></div>
    </c:if>
</div>
<script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
<script type="text/javascript">
    Navbar.init("navbar-left-shop", "navbar-inner-shop-comment");
    $("#paging").paging({
        index: ${result.indexPage},
        total: ${result.totalPage},
        fn : function(r) {
          $("#indexPage").val(r);
          document.forms["queryForm"].submit();
        }
    });
    $("#shopName").click(function(event) {
      ShopSelectDialog.show(function(id, name) {
        $("#shopName").val(name);
        document.forms["queryForm"].action = "${basePath}/shop/" + id + "/comment";
      });
    });
    function deleteComment(id) {
      document.forms['delForm'].action = "${basePath}/shop/${sid}/comment/" + id;
      document.forms['delForm'].submit();
    }
    function addComment() {
      window.location.href = "${basePath}/shop/0/comment/new";
    }
</script>
<%@ include file="../plugin/ShopSelectDialog.jsp" %>
</body>
</html>