<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sec" uri="http://www.qsd.framework.com/tags/sec"%>
<%@ page isELIgnored="false"%>

<%
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();

    String resVer = "?t=20140701";
    String resPath = basePath;

    request.setAttribute("basePath", basePath);
    request.setAttribute("resPath", resPath);
%>