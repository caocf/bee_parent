<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家图片 - <spring:message code="application.name"/></title>

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
        <span class="before">商家图片</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">添加一个商家图片</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test='${msg == null}'>hidden</c:if>" role="alert">${msg}</div>
      </div>
        <form id="submitForm" class="form-horizontal" action="${basePath}/admin/shop/${sid}/image" method="post" enctype="multipart/form-data">
            <input type="hidden" name="shop.sid" value="${image.shop.sid}" />
      <input type="hidden" id="imageId" name="siid" value="${image.siid}" />
      <div class="form-group">
        <label class="col-xs-1 control-label">图片类型</label>
        <div class="col-xs-4">
          <div class="btn-group" data-toggle="buttons">
          <label class="btn btn-default <c:if test="${image.type == 0}">active</c:if>">
              <input type="radio" name="type" value="0" autocomplete="off" <c:if test="${image.type == 0}">checked="checked"</c:if>> &nbsp;主图&nbsp;
            </label>
            <label class="btn btn-default <c:if test="${image.type == 1}">active</c:if>">
              <input type="radio" name="type" value="1" autocomplete="off" <c:if test="${image.type == 1}">checked="checked"</c:if>> 缩略图
            </label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">上传图片</label>
        <div class="col-xs-4">
          <input type="file" id="file" name="file" />
          <input type="hidden" name="url" value="${image.url}" />
          <input type="hidden" name="path" value="${image.path}" />
        </div>
      </div>
      <div class="form-group">
        <div class="col-xs-4 col-xs-offset-1">
          <img id="image" width="120px" height="60px" src="${image.image.mainPic}" />
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">图片说明</label>
        <div class="col-xs-4">
          <input type="text" name="remark" placeholder="图片说明" class="form-control" value="${image.remark}" />
          <p class="help-block">用于图片副标题</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label">排序</label>
        <div class="col-xs-4">
          <input type="text" name="sort" placeholder="排序" class="form-control" value="${image.sort}" />
          <p class="help-block">数字越大越靠前</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-1 control-label"></label>
        <div class="col-xs-4">
          <button type="button" class="btn btn-success" onclick="doSubmit();">保存</button>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/plugin/upload.js"></script>
  <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
  <script type="text/javascript">
    Navbar.init("ShopImage");
    Upload.init("file", "image");
    function doSubmit() {
      if($("#imageId").val() != "") {
        document.forms["submitForm"].action += "/${image.siid}";
      }
      document.forms["submitForm"].submit();
    }
</script>
</body>
</html>