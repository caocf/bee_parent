<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.bee.commons.Consts" %>
<%@ page import="com.bee.admin.commons.AdminConsts" %>
<%@ page import="com.bee.commons.AuthName" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.qsd.framework.com/tags/sec" %>
<%@ page isELIgnored="false" %>

<%
    String basePath = "";
    if (AdminConsts.isDebug) {
        basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    } else {
        basePath = AdminConsts.getBaseUrl();
    }

    String resPath = basePath;
    String imagePath = AdminConsts.GetRemoteImageUrl();
    request.setAttribute("basePath", basePath);
    request.setAttribute("resPath", resPath);
    request.setAttribute("imagePath", imagePath);
%>