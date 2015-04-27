+function($, window, document, undefined) {

	// 项目名
	var ProjectName = window.ProjectName = "";
	// 项目路径
	var BasePath = window.BasePath = window.location.protocol + "//" + window.location.host + "/" + ProjectName;
	// 资源路径
	var ResPath = window.ResPath = BasePath;
	// 开发模式
	var isDebug = window.isDebug = true;

	// Navbar
	var Navbar = window.Navbar = {

		init: function(type) {
			this.Left.init(type);
			this.Inner.init(type);
		},

		Left: {
			init: function(type) {
				if(type == "Home") {
					$("#navbar-left-home").addClass('active');
				} else if(type == "OrderList") {
					$("#navbar-left-order").addClass('active');	
				} else if(type == "ShopList" || type == "ShopView" || type == "ShopNew" || type == "ShopPrice" || type == "ShopImage") {
					$("#navbar-left-shop").addClass('active');
				} else if(type == "SystemArea") {
					$("#navbar-left-system").addClass('active');	
				} 
			}
		},
		Inner: {
			init: function(type) {
				if(type == "ShopList" || type == "ShopView" || type == "ShopPrice" || type == "ShopImage") {
					$("#navbar-inner-shop-list").addClass('active');
				} else if(type == "OrderList") {
					$("#navbar-inner-order-list").addClass('active');
				} else if(type == "ShopNew") {
					$("#navbar-inner-shop-new").addClass('active');
				} else if(type == "SystemArea") {
					$("#navbar-inner-system-area").addClass('active');
				}
			}	
		}
	};

	


} (jQuery, window, document, undefined);