<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>发布广告 - <spring:message code="application.name"/></title>

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
        <span class="before">发布广告</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">发布一个广告</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="${basePath}/admin/ad" method="post" enctype="multipart/form-data">
        <input type="hidden" id="adid" name="adid" value="${ad.adid}" />
        <input type="hidden" name="createTime" value="${ad.createTime}" />
        <div class="form-group">
          <label class="col-xs-1 control-label">广告类型</label>
          <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-default <c:if test="${ad.type == 0}">active</c:if>">
              <input type="radio" name="type" value="<%=Consts.Ad.Type.Home %>" autocomplete="off" <c:if test="${app.type == 0}">checked="checked"</c:if>>首页
            </label>
            <label class="btn btn-default <c:if test="${ad.type == 1}">active</c:if>">
              <input type="radio" name="type" value="<%=Consts.Ad.Type.Party %>" autocomplete="off" <c:if test="${ad.type == 1}">checked="checked"</c:if>>活动
            </label>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">广告图片</label>
          <div class="col-xs-4">
            <input type="file" name="file" />
            <input type="hidden" name="path" value="${ad.path}" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">排序</label>
          <div class="col-xs-4">
            <input type="text" name="sort" placeholder="广告顺序" class="form-control" value="${ad.sort}" />
            <p class="help-block">数字越大越靠前</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">所属商家</label>
          <div class="col-xs-4">
            <input type="text" id="shopId" name="shop.sid" placeholder="广告所属商户" class="form-control" value="${ad.shop.sid}" />
            <p class="help-block">APP广告点击后会进入商家界面</p>
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">下架时间</label>
          <div class="col-xs-4">
            <input type="text" name="stopTime" placeholder="广告下架时间" class="form-control" value="${ad.stopTime}" />
            <p class="help-block">到期后APP上不再显示</p>
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
      Navbar.init("MarketAd");
      function doSubmit() {
        if($("#adid").val() != "") {
          document.forms["submitForm"].action += "/${ad.adid}";
        }
        document.forms["submitForm"].submit();
      } 
    </script>
  </body>
  </html>