<%@ page language="java" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta charset="gbk">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	Error:<br/>
    <%
    	Exception e = (Exception)request.getAttribute("exception");  
    	if(e != null) {
    		out.print(e.getMessage());
    		e.printStackTrace();
    	}
    %>
  </body>
</html>
