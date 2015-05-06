+function($, window, document, undefined) {

	jQuery.fn.map = function(options) {

		// 地图配置
 		var settings = {

 			// DOM对象
 			target: $(this),
			
 			// 宽度，如果为auto则显示100%宽
			width: "auto",

			// 高度，如果为auto则和宽度成正比例
			height: "auto",

			// 样式, 默认无
			// style: {},

			// 初始化城市, 默认上海
			city: "上海",

			// 初始化GPS坐标, GPS坐标优先于城市
			gps: {
				// 是否在地图上标记
				show: false,
				// 经纬度
				lon: undefined,
				lat: undefined
			},

			// 默认地图层级，默认为12级
			zoomLevel: 12,

			// 是否开启缩放平移控件
			navigationControl: true,
			// 缩放平移控件配置
			navigation: {
				// 缩放按钮位置
				anchor: BMAP_ANCHOR_TOP_LEFT,
				// 缩放控件type有四种类型:
				// BMAP_NAVIGATION_CONTROL_LARGE	标准的平移缩放控件（包括平移、缩放按钮和滑块）。
				// BMAP_NAVIGATION_CONTROL_SMALL	仅包含平移和缩放按钮。
				// BMAP_NAVIGATION_CONTROL_PAN	仅包含平移按钮。
				// BMAP_NAVIGATION_CONTROL_ZOOM	仅包含缩放按钮。
				type: BMAP_NAVIGATION_CONTROL_LARGE
			},

			// 是否开启全景地图，默认不开启
			panoramaControl: false,

			// 是否开启鼠标滚轮缩放，默认为false
			scrollWheelZoom: true
		};

		if(options) {
			$.extend(settings, options);
		}

 		return Map.setup(settings);	

	};


	/**
	 * 地图
	 */
	var Map = window.Map = {

		/**
		 * 基础地图对象
		 */
		_map: undefined,

		/**
		 * 配置项
		 */
		_settings: undefined,	

		/**
		 * 装配Map对象
		 */
		setup: function(settings) {

			// 判断地图是否已经初始化
			if(this._map != undefined) {
				return;
			}

			this._settings = settings;

			// 初始化宽高
			this._setViewWidthHeight();

			// 初始化地图
			var map = new BMap.Map(settings.target.attr("id"));
			this._map = map;

			// 是否开启鼠标滚轮缩放
			if(settings.scrollWheelZoom) {
				map.enableScrollWheelZoom(true);
			} else {
				map.disableScrollWheelZoom();
			}
		  // 是否启用放大缩小
		  if(settings.navigationControl) {
		  	map.addControl(new BMap.NavigationControl(settings.navigation));
		  }
		  // 是否启用实景地图
		  if(settings.panoramaControl) {
				map.addControl(new BMap.PanoramaControl());
		  	// map.addTileLayer(new BMap.PanoramaCoverageLayer());
		  }
		  // 是否初始化城市中心点
		  if(settings.city && settings.city != "") {
		  	map.centerAndZoom(settings.city, settings.zoomLevel);
		  }

		  // 是否有默认GPS
		  if(settings.gps.lon != undefined && settings.gps.lat != undefined 
		  	&& settings.gps.lon != "" && settings.gps.lat != "") {
		  	map.centerAndZoom(
		  		settings.gps.lon,
		  		settings.gps.lat,
		  		settings.zoomLevel
		  	);	
		  	if(settings.gps.show) {
			  	this.addPoint({
			  		only: true,
			  		point: new BMap.Point(settings.gps.lon, settings.gps.lat)
			  	});
			  }
		  }

		  return this;
		},

		/**
			* 设置地图视图宽度和高度
			*/
		_setViewWidthHeight: function() {
			var settings = this._settings,
					   $view = settings.target;
 			$view.css("width", settings.width === "auto" ? "100%" : settings.width);
 			if(settings.height === "auto") {
 				$view.height($view.width());
 			} else {
 				$view.height(settings.height);
 			}
 			if(settings.style !== undefined && settings.style.length > 0) {
 				$view.css(settings.style);
 			}
 		},

 		/**
 		 * 设置事件监听
 		 */
 		setEventListener: function(type, fn) {
 			this._map.addEventListener(type, fn);
 		},

 		/**
 		 *
 		 */
 		addPoint: function(options) {
 			if(options.only) {
 				var overlays = this._map.getOverlays();
 				for (var i = 0; i < overlays.length; i++) {
 					if(overlays[i].getTitle() == "MarkerPoint") {
 						this._map.removeOverlay(overlays[i]);
 					}
 				}
 			}
 			var marker = new BMap.Marker(options.point);
 			marker.setTitle("MarkerPoint");
	  	this._map.addOverlay(marker);
 		}


	};


} (jQuery, window, document, undefined);