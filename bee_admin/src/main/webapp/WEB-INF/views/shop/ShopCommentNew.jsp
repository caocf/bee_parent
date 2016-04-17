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
        <div id="errorMsg" class="alert alert-danger hidden" role="alert"></div>
      </div>
      <form id="submitForm" class="form-horizontal" action="" method="post">
        <input type="hidden" name="_method" value="POST" />
        <div class="form-group info-title">基本信息</div> 
        <div class="form-group">
          <label class="col-xs-1 control-label">所属商户</label>
          <label class="col-xs-10 control-value">${shopName}</label>
        </div>
        <div class="form-group">
          <label class="col-xs-1 control-label">评论用户</label>
          <div class="col-xs-10">
            <input type="text" name="userName" class="form-control" />
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
            <button type="button" class="btn btn-success" onclick='doSubmit()'>保存</button>
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

      var doSubmit = function() {
        Loader.show();
        $.post('${basePath}/shop/${sid}/comment', 
          $("#submitForm").serialize(), 
          function(data) {
            Loader.hide();
            if (data.code == 200) {
              window.location.href = "${basePath}/shop/${sid}/comment";
            } else {
              $("#errorMsg").html(data.msg);
              $("#errorMsg").removeClass('hidden');
            }
        }, "json");
      };
    </script>
  </body>
  </html>