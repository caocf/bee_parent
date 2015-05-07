+function($, window, document, undefined) {

	/**
	 * 订单模块
	 */
	var Order = window.Order = {

		Monitor: {
			init: function() {
				window.setInterval(Order.Monitor._queryOrder, 10000); 
			},

			_queryOrder: function() {
				$.getJSON(BasePath + "/admin/order", {status: 10}, function(json, textStatus) {
						if(json == undefined || json == "" || json == null) {
							return;
						}
						if(json.length < 1) {
							return;
						}	
						var $table = $("#orderMonitorTable");
						
						for(var i = 0; i < json.length; i++) {
							var item = json[i];

						}
				});	
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