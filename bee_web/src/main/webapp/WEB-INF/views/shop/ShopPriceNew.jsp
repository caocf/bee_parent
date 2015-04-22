<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家价格 - 大黄蜂后台管理系统</title>

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
        <span class="before">商户价格</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">添加一个商户价格</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg != ''}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form class="form-horizontal" action="${basePath}/admin/shop/${sid}/price" method="post">
        <div class="form-group">
          <label class="col-xs-1 control-label">商家名称</label>
          <div class="col-xs-4">
            <span>${name}</span>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">价格</label>
          <div class="col-xs-4">
            <input type="text" name="price" placeholder="价格" class="form-control" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">价格说明</label>
          <div class="col-xs-4">
            <input type="text" name="mark" placeholder="价格说明" class="form-control" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">价格权重</label>
          <div class="col-xs-4">
            <input type="text" name="sort" placeholder="价格权重" class="form-control" />
            <p class="help-block">数字越大越靠前</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label"></label>
          <div class="col-xs-4">
            <button type="submit" class="btn btn-success btn-lg">创建</button>
          </div>
        </div>
      </form>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript">
      Navbar.Left.init("ShopPrice");
      Navbar.Inner.init("ShopPrice");
    </script>
  </body>
  </html>