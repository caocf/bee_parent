<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家技师 - <spring:message code="application.name"/></title>

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
        <span class="before">添加商家技师</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">添加一个商家技师信息</span>
      </div>
      <div class="row">
        <div id="errorMsg" class="alert alert-danger hidden" role="alert"></div>
      </div>
      <form id="submitForm" class="form-horizontal" action="" method="post">
        <input type="hidden" name="_method" value="POST" />
        <input type="hidden" id="shopTecheeId" name="stId" value="${shopTechee.stId}" />
        <input type="hidden" name="shopGroup.sgId" value="${groupId}" />
        <input type="hidden" name="shop.sid" value="${shopId}" />
        <div class="form-group info-title">基本信息</div> 
        <div class="form-group">
          <label class="col-xs-1 control-label">所属商户</label>
          <label class="col-xs-4 control-value">${groupName}</label>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">编号</label>
          <div class="col-xs-4">
            <input type="text" id="number" name="number" class="form-control" value="${shopTechee.number}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">是否出勤</label>
          <div class="col-xs-4">
            <label class="icheck">
              <input type="checkbox" name="attend" value="1" <c:if test="${shopTechee.attend == 1}">checked="checked"</c:if> />
              是否出勤
            </label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label"></label>
          <div class="col-xs-4">
            <c:if test="${isEdit == 0}">
              <button type="button" class="btn btn-success" onclick='doSubmit(false)'>保存并继续添加</button>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <button type="button" class="btn btn-primary" onclick='doSubmit(true)'>保存完成</button>
            </c:if>
            <c:if test="${isEdit == 1}">
              <button type="button" class="btn btn-success" onclick='doSubmit(true)'>保存</button>
            </c:if>
          </div>
        </div>
      </form>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript">
      Navbar.init("navbar-left-shop", "navbar-inner-shop-list");

      var doSubmit = function(isFinish) {
        Loader.show();
        $.post('${basePath}/shop/${shopId}/group/${groupId}/techee', 
          $("#submitForm").serialize(), 
          function(data) {
            Loader.hide();
            if (data.code == 200) {
              if (isFinish) {
                window.location.href = "${basePath}/shop/${shopId}/group/${groupId}/techee";
              } else {
                $("#number").val("");
              }
            } else {
              $("#errorMsg").html(data.msg);
              $("#errorMsg").removeClass('hidden');
            }
        }, "json");
      };
    </script>
  </body>
  </html>