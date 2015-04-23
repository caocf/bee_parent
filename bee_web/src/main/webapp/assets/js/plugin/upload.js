+function($, window, document, undefined) {

	var Upload = window.Upload = {

		init: function(fileId, imageId) {
			// 绑定事件
			$("#" + fileId).change(function(event) {
				var file = document.getElementById(fileId);
				var image = document.getElementById(imageId);
				if(file.value == "") {
					return;
				}
		    var imgsrc = "";  
		    if("MSIE" == Upload._getBrowser()) {  
		      imgsrc = file.value;  
		    } else {  
		      imgsrc = window.URL.createObjectURL(file.files[0]);  
		    }  
		    image.src = imgsrc;  
			});
		},

		_getBrowser: function() {
			var OsObject = "";    
			if(navigator.userAgent.indexOf("MSIE") > 0) {    
				return "MSIE";    
			} else if(isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {    
				return "Firefox";    
			} else if(isSafari = navigator.userAgent.indexOf("Safari") > 0) {    
				return "Safari";    
			} else if(isCamino = navigator.userAgent.indexOf("Camino") > 0) {    
				return "Camino";    
			} else if(isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {    
				return "Gecko";    
			} 
		}

	};
	

} (jQuery, window, document, undefined);