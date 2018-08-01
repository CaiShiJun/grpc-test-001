<html>
<body>
<%
    String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<li><a href="<%=contextPath%>/grpc-server" target="_blank">grpc-server</a></li>
<li><a href="<%=contextPath%>/streaming-server" target="_blank">streaming-server</a></li>
<li><a href="<%=contextPath%>/route-server" target="_blank">route-server</a></li>
</body>
</html>
