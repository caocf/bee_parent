<%@ page language="java" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${basePath }/admin/index.html">
      	<spring:message code="application.name"/>	
      </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
		    <li class="dropdown">
		      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">APP下载 <span class="caret"></span></a>
		      <ul class="dropdown-menu" role="menu">
		        <li>
		        	<a href="${basePath }/app/android.apk" class="icon-text">
								<i class="fa fa-android fa-lg"></i>Android
		        	</a>
		        </li>
		        <li>
		        	<a href="#" class="icon-text">
		        		<i class="fa fa-apple fa-lg"></i>IOS
		        	</a>
		        </li>
		      </ul>
		    </li>
		  </ul>
    </div>
  </div>
</nav>