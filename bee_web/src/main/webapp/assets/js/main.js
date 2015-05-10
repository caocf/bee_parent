+function($, window, document, undefined) {

	/**
	 * 订单模块
	 */
	var Order = window.Order = {

		Monitor: {

			_queryTime: 0,
			_table: undefined,

			init: function() {
				this._table = $("#orderMonitorTable");
				this._queryOrder();
				window.setInterval(Order.Monitor._queryOrder, 10000); 
			},
			_cacheQueryData: undefined,
			_queryOrder: function() {
				$.post(BasePath + "/admin/order/monitor", 
					{queryTime: Order.Monitor._queryTime}, 
					function(json, textStatus, xhr) {
						if(json == undefined || json == "" || json == null) {
							return;
						}
						if(json.length < 1) {
							return;
						}	
						Order.Monitor._cacheQueryData = json;
						for(var i = 0; i < json.length; i++) {
							var item = json[i];
							var $tr = $(document.createElement("tr"));
							$tr.attr("orderId", item["oid"]);
							$tr.append($(document.createElement("td")).html(item["no"]));
							$tr.append($(document.createElement("td")).html(item["shop"]["typeStr"]));
							$tr.append($(document.createElement("td")).html(item["shop"]["name"]));
							$tr.append($(document.createElement("td")).html(item["orderName"]));
							$tr.append($(document.createElement("td")).html(item["num"]));
							$tr.append($(document.createElement("td")).html(item["orderPhone"]));
							$tr.append($(document.createElement("td")).html(item["execTimeStr"]));
							$tr.append($(document.createElement("td")).html(item["createTimeIng"]));
							var $a = $(document.createElement("a"));
							$a.addClass('icon');
							$a.attr("role", "button");
							$a.attr("item", JSON.stringify(item));
							$a.html("<i class='fa fa-check-square-o fa-lg'></i>");
							$a.click(Order.Monitor._orderItemClick);
							$tr.append($(document.createElement("td")).append($a));
							Order.Monitor._table.append($tr);
						}
						Order.Monitor._queryTime = new Date().getTime();
				}, 'json');	
			},

			_orderItemClick: function() {
				var item = jQuery.parseJSON($(this).attr("item")),
						$shopInfo = $("#dialogShopInfo"),
						$userInfo = $("#dialogUserInfo");
				$("#dialogOrderId").val(item["oid"]);
				$shopInfo.children("dd:eq(1)").html(item["shop"]["name"]);
				$shopInfo.children("dd:eq(3)").html(item["shop"]["linkName"]);
				$shopInfo.children("dd:eq(5)").html(item["shop"]["phone"]);
				$userInfo.children("dd:eq(1)").html(item["orderName"]);
				$userInfo.children("dd:eq(3)").html(item["execTimeStr"]);
				$userInfo.children("dd:eq(5)").html(item["orderPhone"]);
				$("#execuModal").modal('show');
				var $a = $(this);
				var clickItem = function(flag) {
					$.post(
						BasePath + "/admin/order/" + $("#dialogOrderId").val(),  
						{_method: flag ? "put" : "delete"},
						function(data, textStatus, xhr) {
							if(data["code"] == 200) {
								$a.parents("tr").remove();
							}
					},"json");
				};
				$("#orderEnter").click(function(){clickItem(true)});
				$("#orderCancel").click(function(){clickItem(false)});
			}
		},

		doCheck: function(id) {
			document.forms["checkForm"].action = BasePath + "/admin/order/" + id;
			$('#checkModal').modal('show');
		},

		doCheckSubmit: function(flag) {
			if(flag) {
				document.getElementsByName("_method")[0].value = "put";
			} else {
				document.getElementsByName("_method")[0].value = "delete";
			}
			document.forms["checkForm"].submit();
		}

	};	


} (jQuery, window, document, undefined);