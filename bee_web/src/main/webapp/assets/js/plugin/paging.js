+function ($, document) {

	/**
	 * jQuery 分页插件 
   * $("#paging").paging({
			index : 1,
			totel : 1,
			fn : function() {
				...
			}
   })
   *
	 * @author suntongwei
	 */
	jQuery.fn.paging = function(options) {

		$(this).html("");
		$(this).removeClass('paging').addClass('paging');

	 	var settings = {
			index : 0,
			total : 0,
			fn    : function(index) {}
		};

		if(options) {
			$.extend(settings, options);
		}

		var createItem = function(txt, index, fn, disabled) {
			var $item = $(document.createElement("li"));
			$item.html(txt);
			$item.addClass("item");
			$item.attr("index", index);
			if(disabled) {
				$item.addClass("disabled");
			} else {
				$item.click(fn);
				$item.mouseover(function(event) {
					$(this).addClass("active");
				}).mouseout(function(event) {
					$(this).removeClass("active");
				});
			}
			return $item;	
		};
		
		var $lastLi = createItem("&lt; 上一页", null, function(event) {
			var lastIndex = settings.index;
			if(settings.index > 0) {
				lastIndex -= 1;
			}
			settings.fn(lastIndex);
		}, settings.index <= 1);
		$(this).append($lastLi);

		var start = settings.index - 5,
				end   = settings.index + 4;
		var isFirst = true;

		if(end > settings.total) {
			var startSubNum = end - settings.total;
			end = settings.total;
			start -= startSubNum;
		}

		for(var i = start; i <= end; i++) {
			if(i < 1) {
				end = (end + 1) <= settings.total ? end + 1 : settings.total;
				continue;
			}

			if(isFirst) {
				isFirst = false;
				if(i > 1) {
					$(this).append(createItem("1...", 1, function() {
						settings.fn(1);
					}, false));
				}
			}

			var item = createItem(i, i, function(event) {
				settings.fn($(this).attr("index"));
			}, false);
			if(i == settings.index) {
				item.addClass("cur");
			}
			$(this).append(item);
		}

		if(end < settings.total) {
			var total = settings.total > 1000 ? 1000 : settings.total;
			$(this).append(createItem("..." + total, total, function() {
				settings.fn(total);
			}, false));
		}

		var $nextLi = createItem("下一页 &gt;", null, function(event) {
			var nextIndex = settings.index;
			if(settings.index < settings.total) {
				nextIndex += 1;
			}
			settings.fn(nextIndex);
		}, settings.index >= settings.total);
		$(this).append($nextLi);

		var $span = $(document.createElement("span"));
		$span.html("共" + settings.total + "页");
		$(this).append($span);
	};


}(jQuery, document);