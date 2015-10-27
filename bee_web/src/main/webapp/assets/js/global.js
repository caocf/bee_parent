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

		init: function(leftType, innerType) {
			this.Left.setActive(leftType);
			this.Inner.setActive(innerType);
		},

		Left: {

			setActive: function(type) {
				$("#" + type).addClass('active');
			},

			init: function(type) {
				if(type == "Home") {
					$("#navbar-left-home").addClass('active');
				} else if(type == "OrderMonitor" || type == "OrderIng" || type == "OrderEnd") {
					$("#navbar-left-order").addClass('active');	
				} else if(type == "ShopList" || type == "ShopView" || type == "ShopNew" || type == "ShopPrice" || type == "ShopImage") {
					$("#navbar-left-shop").addClass('active');
				} else if(type == "PartyList" || type == "PartyNew") {
					$("#navbar-left-party").addClass('active');
				} else if(type == "StatUser") {
					$("#navbar-left-stat").addClass('active');
				} else if(type == "AppList" || type == "AppNew" || type == "SystemArea") {
					$("#navbar-left-system").addClass('active');	
				} else if(type == "UserApp" || type == "UserVip" || type == "UserPink" || type == "UserBuss" || type == "UserAdmin") {
					$("#navbar-left-user").addClass('active');
				} else if(type == "MarketAd") {
					$("#navbar-left-marketing").addClass('active');
				} else if(type == "FinanceShop") {
					$("#navbar-left-finance").addClass('active');
				} 
			}
		},
		
		Inner: {

			setActive: function(type) {
				$("#" + type).addClass('active');
			},

			init: function(type) {
				if(type == "ShopList" || type == "ShopView" || type == "ShopPrice" || type == "ShopImage") {
					$("#navbar-inner-shop-list").addClass('active');
				} else if(type == "OrderMonitor") {
					$("#navbar-inner-order-monitor").addClass('active');
				} else if(type == "OrderIng") {
					$("#navbar-inner-order-ing").addClass('active');
				} else if(type == "OrderEnd") {
					$("#navbar-inner-order-end").addClass('active');
				} else if(type == "ShopNew") {
					$("#navbar-inner-shop-new").addClass('active');
				} else if(type == "PartyList") {
					$("#navbar-inner-party-list").addClass('active');
				} else if(type == "StatUser") {
					$("#navbar-inner-stat-user").addClass('active');
				} else if(type == "UserApp") {
					$("#navbar-inner-user-app").addClass('active');
				} else if(type == "UserVip") {
					$("#navbar-inner-user-vip").addClass('active');
				} else if(type == "UserPink") {
					$("#navbar-inner-user-pink").addClass('active');
				} else if(type == "UserBuss") {
					$("#navbar-inner-user-buss").addClass('active');
				} else if(type == "UserAdmin") {
					$("#navbar-inner-user-admin").addClass('active');
				} else if(type == "AppList") {
					$("#navbar-inner-system-app").addClass('active');
				} else if(type == "PartyNew") {
					$("#navbar-inner-party-new").addClass('active');
				} else if(type == "AppNew") {
					$("#navbar-inner-system-app-new").addClass('active');
				} else if(type == "MarketAd") {
					$("#navbar-inner-market-ad").addClass('active')
				} else if(type == "SystemArea") {
					$("#navbar-inner-system-area").addClass('active');
				} else if(type == "FinanceShop") {
					$("#navbar-inner-finance-shop").addClass('active');
				}
			}	
		}
	};

	


} (jQuery, window, document, undefined);