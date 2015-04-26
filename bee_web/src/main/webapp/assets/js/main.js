+function($, window, document, undefined) {

	/**
	 * 订单模块
	 */
	var Order = window.Order = {

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