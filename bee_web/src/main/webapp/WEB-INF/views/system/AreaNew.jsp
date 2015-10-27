<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加地区 - <spring:message code="application.name"/></title>

  <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <%@ include file="../includes/navtop.jsp" %>
    <%@ include file="../includes/navleft.jsp" %>
    <%@ include file="SystemMenu.jsp" %>
    <div class="main inner">
      <div class="row title">
        <span class="before">系统地区</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">添加一个系统地区</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/admin/area" method="post">
        <input type="hidden" name="_method" value="post" />
        <input type="hidden" id="aid" name="aid" value="${result.aid}" />
        <div class="form-group">
          <label class="col-xs-1 control-label">地区名</label>
          <div class="col-xs-4">
            <input type="text" name="name" placeholder="城市名" class="form-control" value="${result.area}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">所属地区</label>
          <div class="col-xs-4">
            <input type="text" name="parentId" placeholder="所属上级地区" class="form-control" value="${result.parentId}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">排序</label>
          <div class="col-xs-4">
            <input type="text" name="sort" placeholder="地区显示排序" class="form-control" value="${result.sort}" />
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
    Navbar.init("navbar-left-system", "navbar-inner-system-area");
      function doSubmit() {
        if($("#aid").val() != "") {
          document.forms["submitForm"].action += "/${result.aid}";
          document.getElementsByName("_method")[0].value = "put"; 
        }
        document.forms["submitForm"].submit();
      } 
    </script>
  </body>
  </html>