<html>
<body>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<li><a href="<%=contextPath%>/grpc-client" target="_blank">grpc-client</a></li>
<li><a href="<%=contextPath%>/streaming-client" target="_blank">streaming-client</a></li>
<li><a href="<%=contextPath%>/route-chat" target="_blank">route-chat</a></li>
<li><a href="<%=contextPath%>/route-feature" target="_blank">route-feature</a></li>
<li><a href="<%=contextPath%>/route-listFeatures" target="_blank">route-listFeatures</a></li>
<li><a href="<%=contextPath%>/route-recordRoute" target="_blank">route-recordRoute</a></li>
</body>
</html>
