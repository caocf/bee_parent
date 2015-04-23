<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>商家列表 - 大黄蜂后台管理系统</title>

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
        <span class="before">商户列表</span>
      </div>
      <div class="row query-inner">
        <form class="form-inline">
          <div class="form-group">
            <label>商家名称</label>
            <input type="text" name="name" class="form-control input-sm" />
          </div>
          <div class="form-group">
            <label>手机号</label>
            <input type="text" name="phone" class="form-control input-sm" />
          </div>
          <button type="submit" class="btn btn-primary btn-sm">
            <i class="fa fa-search"></i>查询
          </button>
        </form>
      </div>
      <table class="table table-hover">
        <tr>
          <th>ID</th>
          <th>商家名</th>
          <th>地区</th>
          <th>最低价</th>
          <th>联系人</th>
          <th>电话</th>
          <th>地址</th>
          <th>权重</th>
          <th>操作</th>
        </tr>
        <c:forEach items="${result.data}" var="shop">
          <tr>
            <td>${shop.sid}</td>
            <td>${shop.name}</td>
            <td>${shop.area.name}</td>
            <td><a href="${basePath}/admin/shop/${shop.sid}/price">${shop.priceStr}</a></td>
            <td>${shop.linkName}</td>
            <td>${shop.phone}</td>
            <td>${shop.addr}</td>
            <td>${shop.sort}</td>
            <td>
              <a href="${basePath}/admin/shop/${shop.sid}/image" class="icon" alt="查看图片">
                <i class="fa fa-picture-o fa-lg font-color-green"></i>
              </a>
              <a href="#" class="icon" alt="修改">
                <i class="fa fa-pencil font-color-base fa-lg"></i>
              </a>
              <a href="#" class="icon" alt="删除">
                <i class="fa fa-trash font-color-red fa-lg"></i>
              </a>
            </td>
          </tr>
        </c:forEach>
      </table>
      <div id="paging" class="row"></div>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
    <script type="text/javascript">
      Navbar.Left.init("ShopList");
      Navbar.Inner.init("ShopList");
      $("#paging").paging({
        index : 1,
        totel : 10,
        fn : function(r) {
          alert(r);
        }
      });
    </script>
  </body>
  </html>