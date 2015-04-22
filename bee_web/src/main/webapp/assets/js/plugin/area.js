+function($, window, document, undefined) {

	var Area = window.Area = {

		init: function(target) {
			var $obj = $("#" + target);

		},

		_createElement: function(obj, id) {
			this._queryItem(id, function(){
				var $item = $(document.createElement("select"));
				
			});
		},


		_queryItem: function(id, fn) {
			$.get(BasePath + "/area/" + id, fn);	
		}

	};
	

} (jQuery, window, document, undefined);