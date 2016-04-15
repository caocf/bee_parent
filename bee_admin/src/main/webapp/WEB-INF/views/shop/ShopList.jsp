<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>商家列表 - <spring:message code="application.name"/></title>

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
        <i class="fa fa-angle-double-right"></i>  
        <span class="after">对商户进行管理</span>
      </div>
      <div class="row query-inner">
        <form id="queryForm" class="form-inline" action="${basePath}/shop" method="get">
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
          <th>类型</th>
          <th>地区</th>
          <th>最低价</th>
          <th>状态</th>
          <th>权重</th>
          <th>加入时间</th>
          <th>操作</th>
        </tr>
        <c:forEach items="${result.data}" var="shop">
          <tr>
            <td>${shop.sid}</td>
            <td><a href="${basePath}/shop/${shop.sid}">${shop.name}</a></td>
            <td>${shop.typeStr}</td>
            <td>${shop.area.name}</td>
            <td>
                <sec:security auth="<%=AuthName.ShopGroup%>">
                    <a href="${basePath}/shop/${shop.sid}/group">
                </sec:security>
                    ${shop.priceStr}
                    <sec:security auth="<%=AuthName.ShopGroup%>">
                    </a>
                </sec:security>
            </td>
            <td>${shop.statusStr}</td>
            <td>${shop.sort}</td>
            <td>${shop.createTimeStr}</td>
            <td>
                <sec:security auth="<%=AuthName.ShopUser%>">
              <a href="${basePath}/shop/${shop.sid}/admin" class="icon">
                <i class="fa fa-street-view fa-lg font-color-gray"></i>
              </a>
                </sec:security>
              <a href="${basePath}/shop/${shop.sid}/comment" class="icon">
                <i class="fa fa-commenting-o fa-lg font-color-yellow"></i>
              </a>
                <sec:security auth="<%=AuthName.ShopImage%>">
              <a href="${basePath}/shop/${shop.sid}/image" class="icon">
                <i class="fa fa-picture-o fa-lg font-color-green"></i>
              </a>
                </sec:security>
                <sec:security auth="<%=AuthName.ShopEdit %>">
              <a href="${basePath}/shop/${shop.sid}/edit" class="icon">
                <i class="fa fa-pencil font-color-base fa-lg"></i>
              </a>
                </sec:security>
                <sec:security auth="<%=AuthName.ShopDelete %>">
              <a href="#" class="icon" onclick="confirmDelete(${shop.sid})">
                <i class="fa fa-trash font-color-red fa-lg"></i>
              </a>
                </sec:security>
            </td>
          </tr>
        </c:forEach>
      </table>
      <div id="paging" class="row"></div>
    </div>
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="deleteModalLabel">提示确认</h4>
          </div>
          <div class="modal-body">
            确定删除该商家？删除后商家状态会改变成关闭
          </div>
          <div class="modal-footer">
            <form:form id="delForm" method="delete"></form:form>
            <button type="button" class="btn btn-success icon-text" data-dismiss="modal" onclick="delShop();">
              <i class="fa fa-check"></i>确定
            </button>
            <button type="button" class="btn btn-danger icon-text" data-dismiss="modal">
              <i class="fa fa-times"></i>取消
            </button>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="${resPath}/assets/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
    <script type="text/javascript" src="${resPath}/assets/js/plugin/area.js"></script>
    <script type="text/javascript">
      Navbar.init("navbar-left-shop", "navbar-inner-shop-list");
      $("#paging").paging({
        index: ${result.indexPage},
        total: ${result.totalPage},
        count: ${result.totalData},
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
      function confirmDelete(id) {
        document.forms["delForm"].action = "${basePath}/shop/" + id;
        $("#deleteModal").modal('show');
      }
      function delShop() {
        document.forms["delForm"].submit();
      }
    </script>
  </body>
  </html>