<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
	
	var UserSelectDialog = window.UserSelectDialog = {

		_fn: function(id, name) {},

		show: function(fn) {
			this._fn = fn;
			$("#userSelectDialog").modal('show');
		},

		query: function(index) {
			$.getJSON(BasePath + "/user/json", {
				userName: $("#userSelectDialogName").val(),
				type: $("#userSelectDialogType").val(),
				maxRows: 10,
				indexPage: index
			}, function(data) {
				$("#userSelectDialogTable tr:gt(0)").remove();
				for (var i = 0; i < data.result.length; i++) {
					var $tr = $(document.createElement("tr"));
					var $a = $(document.createElement("a"));
					$a.html("选择");
					$a.attr("href", "#");
					$a.attr("userId", data.result[i].uid);
					$a.attr("userName", data.result[i].name);
					$a.click(function(event) {
						$("#userSelectDialog").modal('hide');
						UserSelectDialog._fn($(this).attr("userId"), $(this).attr("userName"));
					});
					$tr.append($(document.createElement("td")).append($a));
					$tr.append($(document.createElement("td")).html(data.result[i].phone));
					$tr.append($(document.createElement("td")).html(data.result[i].name));
					if (data.result[i].type == 99) {
						$tr.append($(document.createElement("td")).html("测试用户"));
					} else {
						$tr.append($(document.createElement("td")).html("普通用户"));
					}
					
					$("#userSelectDialogTable").append($tr);
				}	
				$("#userSelectDialogPaging").paging({
	        index: data.indexPage,
	        total: data.totalPage,
	        fn : function(r) {
	          UserSelectDialog.query(r);
	        }
	      });
			});
		}
	};

</script>

<div class="modal fade" id="userSelectDialog" tabindex="-1" role="dialog" aria-labelledby="userSelectTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="userSelectTitle">用户选择</h4>
      </div>
      <div class="modal-body">
      	<div class="container-fluid">
      	<form action="${basePath}/user" class="form-inline" method="get">
          <div class="row query_div">
	          <div class="col-xs-12">
			          <div class="form-group">
			            <label>用户名称</label>
			            <input type="text" id="userSelectDialogName" class="form-control input-sm" />
			          </div>
			          <div class="form-group">
			            <label>用户类型</label>
			            <select id="userSelectDialogType">
			            	<option></option>
			            	<option value="<%= Consts.User.Type.AppUser %>">普通用户</option>
			            	<option value="<%= Consts.User.Type.TestUser %>">测试用户</option>
			            	<option value="<%= Consts.User.Type.BusiUser %>">商家用户</option>
			            </select>
			          </div>
			          <button type="button" class="btn btn-primary btn-sm icon-text" onclick="UserSelectDialog.query(1)">
			            <i class="fa fa-search"></i>查询
			          </button>
		        </div>
          </div>
          </form>
          <div class="row">
          	<div class="col-xs-12">
		        	<table id="userSelectDialogTable" class="table table-hover">
				        <tr>
				          <th>操作</th>
				          <th>手机号</th>
				          <th>用户名</th>
				          <th>类型</th>
				        </tr>
		        	</table>
		        </div>
          </div>
          <div id="userSelectDialogPaging" class="row"></div>
        </div>
      </div>
    </div>
  </div>
</div>