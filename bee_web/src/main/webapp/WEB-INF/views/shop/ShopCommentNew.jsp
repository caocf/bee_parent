<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>添加商家评论 - <spring:message code="application.name"/></title>

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
        <span class="before">添加商家评论</span>
        <i class="fa fa-angle-double-right"></i>    
        <span class="after">添加一个商家评论</span>
      </div>
      <div class="row">
        <div class="alert alert-danger <c:if test="${msg == null}">hidden</c:if>" role="alert">${msg}</div>
      </div>
      <form id="submitForm" class="form-horizontal" action="" method="post">
        <input type="hidden" name="_method" value="POST" />
        <div class="form-group info-title">基本信息</div> 
        <div class="form-group">
          <label class="col-xs-1 control-label">所属商户</label>
          <div class="col-xs-4">
            <input type="text" id="shopName" class="form-control" />
          </div>
          <label class="col-xs-2 control-label">评论用户</label>
          <div class="col-xs-4">
            <input type="text" id="userName" name="userName" class="form-control" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">评论内容</label>
          <div class="col-xs-10">
            <div class="textarea">
              <textarea type="form-control" name="content" rows="5"></textarea>
            </div>
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
    <%@ include file="../plugin/ShopSelectDialog.jsp" %>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
    <script type="text/javascript">
      Navbar.init("navbar-left-shop", "navbar-inner-shop-comment");
      $("#shopName").click(function(event) {
        ShopSelectDialog.show(function(id, name) {
          document.forms["submitForm"].action = BasePath + "admin/shop/" + id + "/comment";
          $("#shopName").val(name);
        });
      });

      function doSubmit() {
        if (document.forms["submitForm"].action == "") {
          alert("请选择商家");
        } else {
          document.forms["submitForm"].submit();
        }
      }
    </script>
  </body>
  </html>