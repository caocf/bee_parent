<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家价格 - <spring:message code="application.name"/></title>

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
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/admin/shop/${sid}/price" method="post">
        <input type="hidden" name="_method" value="post" />
        <input type="hidden" name="isRegShop" value="${isRegShop}" />
        <input type="hidden" id="spid" name="spid" value="${result.spid}" />
        <input type="hidden" name="shop.sid" value="${result.shop.sid}" />
        <div class="form-group">
          <label class="col-xs-1 control-label">商家名称</label>
          <div class="col-xs-4">
            <p class="form-control-static">${shop.name}</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">价格</label>
          <div class="col-xs-4">
            <input type="text" name="price" placeholder="价格" class="form-control" value="${result.price}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">价格说明</label>
          <div class="col-xs-4">
            <input type="text" name="mark" placeholder="价格说明" class="form-control" value="${result.mark}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">价格权重</label>
          <div class="col-xs-4">
            <input type="text" name="sort" placeholder="价格权重" class="form-control" value="${result.sort}" />
            <p class="help-block">数字越大越靠前</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label"></label>
          <div class="col-xs-4">
            <button type="button" class="btn btn-success" onclick="doSubmit()">保存</button>
          </div>
        </div>
      </form>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript">
      Navbar.init("ShopPrice");
      function doSubmit() {
        if($("#spid").val() != "") {
          document.forms["submitForm"].action += "/${result.spid}";
          document.getElementsByName("_method")[0].value = "put"; 
        }
        document.forms["submitForm"].submit();
      } 
    </script>
  </body>
  </html>