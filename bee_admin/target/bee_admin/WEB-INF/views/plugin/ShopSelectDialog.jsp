<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
	var ShopSelectDialog = window.ShopSelectDialog = {
		_fn: function(id, name) {},
		_isLoadArea: false,
		show: function(fn) {
			this._fn = fn;
			if (!this._isLoadArea) {
				$("#shopSelectDialogArea").area({
	        areaId: $("#shopSelectDialogAreaId").val(),
	        initId: 1,
	        hasNull: true,
	        fn: function(r) {
	          $("#shopSelectDialogAreaId").val(r);
	        }
	      });
				this._isLoadArea = true;
			}
			$("#shopSelectDialog").modal('show');
		}, 
		query: function(index) {
			$.getJSON(BasePath + "/shop/json", {
				name: $("#shopSelectDialogName").val(),
				type: $("#shopSelectDialogType").val(),
				areaId: $("#shopSelectDialogAreaId").val(),
				indexPage: index
			}, function(data) {
				$("#shopSelectDialogTable tr:gt(0)").remove();
				for (var i = 0; i < data.data.length; i++) {
					var $tr = $(document.createElement("tr"));
					var $a = $(document.createElement("a"));
					$a.html("选择");
					$a.attr("href", "#");
					$a.attr("shopId", data.data[i].sid);
					$a.attr("shopName", data.data[i].name);
					$a.click(function(event) {
						$("#shopSelectDialog").modal('hide');
						ShopSelectDialog._fn($(this).attr("shopId"), $(this).attr("shopName"));
					});
					$tr.append($(document.createElement("td")).append($a));
					$tr.append($(document.createElement("td")).html(data.data[i].name));
					$tr.append($(document.createElement("td")).html(data.data[i].typeStr));
					$tr.append($(document.createElement("td")).html(data.data[i].area.name));
					$("#shopSelectDialogTable").append($tr);
				}	
				$("#shopSelectDialogPaging").paging({
	        index: data.indexPage,
	        total: data.totalPage,
	        fn : function(r) {
	          ShopSelectDialog.query(r);
	        }
	      });
			});
		}
	};
</script>

<div class="modal fade" id="shopSelectDialog" tabindex="-1" role="dialog" aria-labelledby="shopSelectTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="shopSelectTitle">商家选择</h4>
      </div>
      <div class="modal-body">
      	<div class="container-fluid">
      	<form action="${basePath}/shop" class="form-inline" method="get">
          <div class="row query_div">
	          <div class="col-xs-12">
			          <div class="form-group">
			            <label>商家名称</label>
			            <input type="text" id="shopSelectDialogName" class="form-control input-sm" />
			          </div>	          
			          <div id="shopSelectDialogArea" class="form-group">
			            <label>地区</label>
			            <input type="hidden" id="shopSelectDialogAreaId" />
			          </div>
			          <div class="form-group">
			            <label>类型</label>
			            <select id="shopSelectDialogType">
			              <option></option>
			              <c:forEach items="<%= Consts.Shop.Type.Select() %>" var="type">
			                <option value="${type.key}">${type.value}</option>
			              </c:forEach>
			            </select>
			          </div>
			          <button type="button" class="btn btn-primary btn-sm icon-text" onclick="ShopSelectDialog.query(1)">
			            <i class="fa fa-search"></i>查询
			          </button>
		        </div>
          </div>
          </form>
          <div class="row">
          	<div class="col-xs-12">
		        	<table id="shopSelectDialogTable" class="table table-hover">
				        <tr>
				          <th>操作</th>
				          <th>商家名</th>
				          <th>类型</th>
				          <th>地区</th>
				        </tr>
		        	</table>
		        </div>
          </div>
          <div id="shopSelectDialogPaging" class="row"></div>
        </div>
      </div>
    </div>
  </div>
</div>