<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>发布版本 - <spring:message code="application.name"/></title>

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
        <span class="before">发布版本</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">发布一个Android和iOS版本</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/app" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_method" value="post" />
        <input type="hidden" id="avid" name="avid" value="${app.avid}" />
        <input type="hidden" name="createTime" value="${app.createTime}" />
        <div class="form-group">
          <label class="col-xs-1 control-label">版本类型</label>
          <div class="col-xs-4">
            <select name="type">
              <c:forEach items="${selects}" var="t">
              <option value="${t.key}" <c:if test="${app.type == t.key}">selected="selected"</c:if>>${t.value}</option>
              </c:forEach>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">App文件</label>
          <div class="col-xs-4">
            <input type="file" name="file" />
            <input type="hidden" name="path" value="${app.path}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">版本号</label>
          <div class="col-xs-4">
            <input type="text" name="verStr" placeholder="版本号" class="form-control" value="${app.verStr}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">版本码</label>
          <div class="col-xs-4">
            <input type="text" name="ver" placeholder="整数版本号" class="form-control" value="${app.ver}" />
            <p class="help-block">数字越大，版本越新</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">版本说明</label>
          <div class="col-xs-4">
              <input type="text" name="remark" placeholder="版本说明" class="form-control" value="${app.remark}" />
              <p class="help-block">数字越大，版本越新</p>
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
      Navbar.init("navbar-left-system", "navbar-inner-system-app-new");
      function doSubmit() {
        if($("#avid").val() != "") {
          document.forms["submitForm"].action += "/${app.avid}";
          document.getElementsByName("_method")[0].value = "put"; 
        }
        document.forms["submitForm"].submit();
      } 
    </script>
  </body>
  </html>