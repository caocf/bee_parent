<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
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
        <form id="queryForm" class="form-inline" action="${basePath}/admin/shop" method="get">
          <input type="hidden" name="indexPage" id="indexPage" value="${result.indexPage}" />
          <div class="form-group">
            <label>商家名称</label>
            <input type="text" name="name" class="form-control input-sm" value="${params.name}" />
          </div>
          <div class="form-group">
            <label>手机号</label>
            <input type="text" name="phone" class="form-control input-sm" value="${params.phone}" />
          </div>
          <div id="area" class="form-group">
            <label>地区</label>
            <input type="hidden" name="areaId" id="areaId" value="${params.areaId}" />
          </div>
          <div class="form-group">
            <label>类型</label>
            <select name="type">
              <option></option>
              <c:forEach items="<%= Consts.Shop.Type.Select() %>" var="type">
                <option value="${type.key}" <c:if test="${type.key == params.type}">selected="selected"</c:if>>${type.value}</option>
              </c:forEach>
            </select>
          </div>
          <button type="submit" class="btn btn-primary btn-sm icon-text">
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
          <th>关注数</th>
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
            <td>${shop.focusNum}</td>
            <td>${shop.sort}</td>
            <td>
              <a href="#" class="icon">
                <i class="fa fa-file-text-o fa-lg font-color-gray"></i>
              </a>
              <a href="${basePath}/admin/shop/${shop.sid}/image" class="icon">
                <i class="fa fa-picture-o fa-lg font-color-green"></i>
              </a>
              <a href="#" class="icon">
                <i class="fa fa-pencil font-color-base fa-lg"></i>
              </a>
              <a href="#" class="icon">
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
    <script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
    <script type="text/javascript">
      Navbar.Left.init("ShopList");
      Navbar.Inner.init("ShopList");
      $("#paging").paging({
        index: ${result.indexPage},
        total: ${result.totalPage},
        fn : function(r) {
          $("#indexPage").val(r);
          document.forms["queryForm"].submit();
        }
      });
      $("#area").area({
        areaId: $("#areaId").val(),
        initId: 1,
        hasNull: true,
        fn: function(r) {
          $("#areaId").val(r);
        }
      });
    </script>
  </body>
  </html>