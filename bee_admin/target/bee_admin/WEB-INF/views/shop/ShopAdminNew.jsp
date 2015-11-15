<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家管理员 - <spring:message code="application.name"/></title>

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
        <span class="before">商家管理员</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">添加一个商家管理员</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/shop/${sid}/admin" method="post">
        <input type="hidden" name="_method" value="post" />
        <div class="form-group">
          <label class="col-xs-1 control-label">商家名称</label>
          <div class="col-xs-4">
            <p class="form-control-static">${shop.name}</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">用户帐号</label>
          <div class="col-xs-4">
            <input type="text" name="account" placeholder="手机号" class="form-control" value="${request.account}" />
            <p class="help-block">商家管理员手机号，用于登录</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">用户名称</label>
          <div class="col-xs-4">
            <input type="text" name="name" placeholder="用户名称" class="form-control" value="${request.name}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label"></label>
          <div class="col-xs-4">
            <button type="submit" class="btn btn-success">保存</button>
          </div>
        </div>
      </form>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript">
      Navbar.init("ShopAdmin");
    </script>
  </body>
  </html>