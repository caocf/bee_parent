<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单列表 - <spring:message code="application.name"/></title>
    <link href="${resPath}/assets/css/main.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${resPath}/assets/js/bootstrap/html5shiv.min.js"></script>
    <script src="${resPath}/assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="../includes/navtop.jsp" %>
<%@ include file="../includes/navleft.jsp" %>
<%@ include file="OrderMenu.jsp" %>
<div class="main inner">
    <div class="row title">
        <span class="before">订单列表</span>
        <i class="fa fa-angle-double-right"></i>
        <span class="after">订单管理列表</span>
    </div>
    <div class="row query-inner">
      <input type="hidden" id="pageType" value="${params.pageType}" />
      <input type="hidden" id="status" value="${params.status}" />
      <c:if test="${params.pageType == 'navbar-inner-order-ing'}">
        <button id="btnAutoRefresh" type="button" class="btn btn-primary btn-sm icon-text">
          <i class="fa fa-play"></i>开启自动刷新
        </button>
        <button id="btnRefresh" type="button" class="btn btn-success btn-sm icon-text">
          <i class="fa fa-refresh"></i>手动刷新
        </button>
      </c:if>
    </div>
    <div id="content" class="row"></div>
    <script id="temp" type="text/html">
        <table class="table table-hover">
            <tr>
                <th>订单编号</th>
                <th>预约商家</th>
                <th>商家电话</th>
                <th>预约人</th>
                <th>预约人数</th>
                <th>用户电话</th>
                <th>预约时间</th>
                <th>状态</th>
                <th>下单时间</th>
                <th>操作</th>
            </tr>
            {{if totalData < 1}}
              <tr>
                <td colspan="10" class="text-center">
                  <i class="fa fa-exclamation-triangle fa-lg font-color-red"></i> 暂时没有新的订单
                </td>
              </tr>
            {{/if}}
            {{each result}}
              <tr>
                <td>
                    <a href="${basePath}/order/{{$value.oid}}">{{$value.no}}</a>
                </td>
                <td>{{$value.shop.name}}</td>
                <td>
                  {{if $value.shopUser}}
                    {{$value.shopUser.phone}}
                  {{/if}}
                </td>
                <td>{{$value.orderName}}</td>
                <td>
                  <a href="#" onclick="confirmUpdateNum({{$value.oid}}, {{$value.num}})">{{$value.num}}人</a>
                </td>
                <td>{{$value.orderPhone}}</td>
                <td>{{$value.execTimeStr}}</td>
                <td>{{$value.statusStr}}</td>
                <td>{{$value.createTimeStr}}</td>
                <td>
                  {{if $value.status == 1}}
                    <a href="#" class="icon" onclick="accept({{$value.oid}})">
                      <i class="fa fa-check-square-o font-color-base fa-lg"></i>
                    </a>
                  {{/if}}
                  {{if $value.status == 10}}
                    <a href="#" class="icon" onclick="finish({{$value.oid}})">
                      <i class="fa fa-check font-color-green fa-lg"></i>
                    </a>
                  {{/if}}
                  {{if $value.status < 50}}
                    <sec:security auth="<%=AuthName.OrderDelete %>">
                        <a href="#" class="icon" onclick="confirmDelete({{$value.oid}})">
                            <i class="fa fa-close font-color-red fa-lg"></i>
                        </a>
                    </sec:security>
                  {{/if}}

                </td>
              </tr>
            {{/each}}
        </table>
    </script>
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
                确定删除取消该订单？
            </div>
            <div class="modal-footer">
                <input type="hidden" id="deleteOrderId" />
                <button type="button" class="btn btn-success icon-text" data-dismiss="modal" onclick="delOrder();">
                    <i class="fa fa-check"></i>确定
                </button>
                <button type="button" class="btn btn-danger icon-text" data-dismiss="modal">
                    <i class="fa fa-times"></i>取消
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateNumModal" tabindex="-1" role="dialog" aria-labelledby="updateNumModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="updateNumModalLabel">修改人数</h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="updateOrderId" />
                <input type="text" id="updateOrderNum" class="form-control" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success icon-text" data-dismiss="modal" onclick="updateOrderNum()">
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
<script type="text/javascript" src="${resPath}/assets/js/plugin/artTemplate/template.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/global.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/main.js"></script>
<script type="text/javascript" src="${resPath}/assets/js/plugin/paging.js"></script>
<script type="text/javascript">
    Navbar.init("navbar-left-order", "${params.pageType}");

    var indexPage = 1;
    var intervalId = undefined;
    var autoTime = 300000;

    // 查询
    var query = function(hasLoader) {
      if (hasLoader) Loader.show();
      $.getJSON("${basePath}/order/json", 
        {indexPage: indexPage, status: $("#status").val()}, 
        function(data) {
          if (hasLoader) Loader.hide();
          $('#content').html(template('temp', data));
          if (data.totalPage > 0) {
            $("#paging").paging({
              index: data.indexPage,
              total: data.totalPage,
              count: data.totalData,
              fn : function(r) {
                indexPage = r;
                query();
              }
            });
          }
        });
    };

    $(document).ready(function() {
      // 查询数据
      query(true);
      // 手动刷新
      $("#btnRefresh").click(function(event) {
        query(true);
      });
      // 自动刷新
      $("#btnAutoRefresh").click(function(event) {
        if (intervalId == undefined) {
          $(this).html("<i class=\"fa fa-stop\"></i>停止自动刷新");
          $(this).removeClass('btn-primary');
          $(this).addClass('btn-danger');
          intervalId = setInterval(function() {
            query(false);
          }, autoTime);
        } else {
          $(this).html("<i class=\"fa fa-play\"></i>启动自动刷新");
          $(this).removeClass('btn-danger');
          $(this).addClass('btn-primary');
          window.clearInterval(intervalId);
        }
      });
    });

    function accept(id) {
      $.post('${basePath}/order/' + id, {_method: "put"}, function(data, textStatus, xhr) {
        query(true);
      });
    }

    function finish(id) {
      $.post('${basePath}/order/' + id, {_method: "post"}, function(data, textStatus, xhr) {
        query(true);
      });
    }

    function confirmUpdateNum(id, num) {
      $("#updateOrderId").val(id);
      $("#updateOrderNum").val(num);
      $("#updateNumModal").modal('show');
    }

    function updateOrderNum() {
      $.post('${basePath}/order/' + $("#updateOrderId").val() + '/edit/num', 
        {_method: "PATCH", num: $("#updateOrderNum").val()}, 
        function(data, textStatus, xhr) {
        query(true);
      });
    }

    function confirmDelete(id) {
      $("#deleteOrderId").val(id);
      $("#deleteModal").modal('show');
    }

    function delOrder() {
      $.post('${basePath}/order/' + $("#deleteOrderId").val(), {_method: "delete"}, function(data, textStatus, xhr) {
        query(true);
      });
    }

</script>
</body>
</html>