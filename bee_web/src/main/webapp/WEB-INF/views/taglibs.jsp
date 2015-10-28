<%@ page import="com.bee.commons.Consts" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.qsd.framework.com/tags/sec" %>
<%@ page isELIgnored="false" %>

<%
    String basePath = "";
    if (Consts.isDebug) {
        basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    } else {
        basePath = Consts.getBaseUrl();
    }

    String resPath = basePath;
    String imagePath = Consts.GetRemoteImageUrl();
    request.setAttribute("basePath", basePath);
    request.setAttribute("resPath", resPath);
%>