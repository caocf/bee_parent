<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${action}手机充值卡 - <spring:message code="application.name"/></title>

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
        <span class="before">${action}手机充值卡</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">${action}一个手机充值卡</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/admin/store/0/phone" method="post">
        <input type="hidden" name="_method" value="post" />
        <input type="hidden" id="pcId" name="pcId" value="${phoneCard.pcId}" />
        <input type="hidden" name="createTime" value="${phoneCard.createTime}" />
        <input type="hidden" name="status" value="${phoneCard.status}" />
        <div class="form-group info-title">基本信息</div>
        <div class="form-group">
          <label class="col-xs-1 control-label">手机卡密</label>
          <div class="col-xs-4">
            <input type="text" name="cardNumber" placeholder="手机卡密" class="form-control" value="${phoneCard.cardNumber}" />
          </div>
          <label class="col-xs-2 control-label">运营商</label>
          <div class="col-xs-4">
            <select name="operator">
              <c:forEach items="<%= Consts.GetOperatorSelect() %>" var="type">
              <option value="${type.key}" <c:if test="${phoneCard.operator == type.key}">selected="selected"</c:if>>${type.value}</option>
              </c:forEach>
            </select>
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
      Navbar.init("navbar-left-marketing", "navbar-inner-market-phone");
      function doSubmit() {
        if($("#pcId").val() != "") {
          document.forms["submitForm"].action += "/${phoneCard.pcId}";
          document.getElementsByName("_method")[0].value = "put"; 
        }
        document.forms["submitForm"].submit();
      } 
    </script>
  </body>
  </html>