<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>增加积分商城商品 - <spring:message code="application.name"/></title>

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
        <span class="before"><c:if test="${action == 'new'}">新增</c:if><c:if test="${action == 'edit'}">修改</c:if>商品</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">增加一个积分商城的商品</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/admin/store/save" method="post" enctype="multipart/form-data">
        <input type="hidden" id="gid" name="gid" value="${goods.gid}" />
        <input type="hidden" name="number" <c:if test="${action == 'new'}">value="0"</c:if><c:if test="${action == 'edit'}">value="${goods.number}"</c:if> />
        <div class="form-group info-title">基本信息</div>
        <div class="form-group">
          <label class="col-xs-1 control-label">商品名称</label>
          <div class="col-xs-4">
            <input type="text" name="name" placeholder="商品名称" class="form-control" value="${goods.name}" />
          </div>
          <label class="col-xs-2 control-label">商品状态</label>
          <div class="col-xs-4">
            <select name="status">
              <option value="1" <c:if test="${goods.status == 1}">selected="selected"</c:if>>上架</option>
              <option value="2" <c:if test="${goods.status == 2}">selected="selected"</c:if>>下架</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">商品类型</label>
          <div class="col-xs-4">
            <select name="type">
              <c:forEach items="<%= Consts.Goods.Type.Select() %>" var="type">
              <option value="${type.key}" <c:if test="${goods.type == type.key}">selected="selected"</c:if>>${type.value}</option>
              </c:forEach>
            </select>
          </div>
          <label class="col-xs-2 control-label">所需积分</label>
          <div class="col-xs-4">
            <input type="text" name="integral" placeholder="兑换商品所需积分" class="form-control" value="${goods.integral}" />
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
      Navbar.init("navbar-left-marketing", "navbar-inner-market-store");
      function doSubmit() {
        if($("#gid").val() != "") {
          document.forms["submitForm"].action += "/${goods.gid}";
        }
        document.forms["submitForm"].submit();
      } 
    </script>
  </body>
  </html>