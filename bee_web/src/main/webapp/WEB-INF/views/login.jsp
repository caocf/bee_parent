<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>登录 - <spring:message code="application.name"/></title>

  <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
  <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
  <![endif]-->
</head>
<body class="login">
	<div class="container">
		<div class="row text-center">
			<h2 class="font-color-orange">小黄蜂&nbsp;<span class="font-color-white">管理后台系统</span></h2>
		</div>
		<div class="row text-center">
			<h4 class="font-color-base">&copy; Bee</h4>
		</div>
		<div class="row">
			<div class="col-xs-11 col-xs-offset-1 col-md-4 col-md-offset-4">
				<div class="box out-side">
					<div class="context">
						<div class="dialog-title">
							<i class="fa fa-coffee font-color-green"></i>
							&nbsp;Please Enter Your Information
						</div>
						<form action="${basePath }/admin/login.html" method="post">
              <div class="input-group margin-bottom-sm">
                  <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
                  <input class="form-control" name="account" type="text" placeholder="用户名" />
              </div>
              <div class="input-group">
                  <span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span>
                  <input class="form-control" name="password" type="password" placeholder="密码" />
              </div>
              <div class="input-group text-right">
              	<button type="submit" class="btn btn-primary">
              		<i class="fa fa-key fa-fw"></i>&nbsp;&nbsp;登录
              	</button>
              </div>
						</form>
					</div>
				</div>	
			</div>
		</div>
	</div>
<script src="${resPath}/assets/js/jquery/jquery.min.js"></script>
<script src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>