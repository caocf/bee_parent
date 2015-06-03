+function($, window, document, undefined) {

	jQuery.fn.area = function(options) {

		var $this = $(this);
		var settings = {
			initId: 0,
			areaId: -1,
			hasNull: false,
			fn: function(id){}
		};

		if(options) {
			$.extend(settings, options);
		}	

		var createSelect = function(parentId) {
			$.getJSON(BasePath + "/area/" + parentId, function(data) {
				if(null == data || data == undefined || data == "" || data.length < 1) {
					return;
				}
				var $select = $(document.createElement("select"));
				if(settings.hasNull) {
                    $select.append($(document.createElement("option")));
                }
				$.each(data, function(index, val) {
                    if(index == 0 && !settings.hasNull) {
                        $this.val(data[index].aid);
                    }
					var $option = $(document.createElement("option"));
					$option.val(data[index].aid);
					$option.html(data[index].name);
					// 判断是否是选中
					if(settings.areaId == data[index].aid) {
						$option.attr("selected", "selected");
					}	
					$select.append($option);
				});
				$select.change(function(event) {	
					settings.fn($(this).val());
				});
				$this.append($select);
			});	
		};

		createSelect(settings.initId);

	};	

} (jQuery, window, document, undefined);