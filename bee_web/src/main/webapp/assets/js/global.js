+function($, window, document, undefined) {

	var Navbar = window.Navbar = {
		Left: {
			init: function(type) {
				if(type == "Home") {
					$("#navbar-left-home").addClass('active');
				} else if(type == "ShopList" || type == "ShopNew") {
					$("#navbar-left-shop").addClass('active');
				}
			}
		},
		Inner: {
			init: function(type) {
				if(type == "ShopList" || type == "ShopPrice") {
					$("#navbar-inner-shop-list").addClass('active');
				} else if(type == "ShopNew") {
					$("#navbar-inner-shop-new").addClass('active');
				}
			}	
		}
	};


} (jQuery, window, document, undefined);