<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>商家列表 - Bee Admin</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="${resPath}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${resPath}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${resPath}/assets/fonts/fonts.googleapis.com.css" />
    <link rel="stylesheet" href="${resPath}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${resPath}/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${resPath}/assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="${resPath}/assets/js/ace-extra.min.js"></script>
    <!--[if lte IE 8]>
    <script src="${resPath}/assets/js/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<%@ include file="../includes/navtop.jsp" %>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <%@ include file="../includes/sidebar.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>
                <ul class="breadcrumb">
                    <li class="active">
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="${basePath}/admin/index.html">商家管理</a>
                    </li>
                </ul>
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        
                    </div>
                </div>
            </div>
        </div>
    </div><!-- /.main-content -->

    <%@ include file="../includes/footer.jsp" %>
</div><!-- /.main-container -->

<!--[if !IE]> -->
<script src="${resPath}/assets/js/jquery.2.1.1.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="${resPath}/assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->
<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${resPath}/assets/js/jquery.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${resPath}/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='${resPath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${resPath}/assets/js/bootstrap.min.js"></script>
<script src="${resPath}/assets/js/ace-elements.min.js"></script>
<script src="${resPath}/assets/js/ace.min.js"></script>

</body>
</html>