<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello</h1>
    <%-- https://github.com/jmesnil/stomp-websocket --%>
    <script src="<c:url value="/public/vendors/stomp.js"/>"></script>
    <%-- https://github.com/sockjs/sockjs-client --%>
    <script src="<c:url value="/public/vendors/sockjs-0.3.4.js"/>"></script>

    <script src="<c:url value="/public/js/app.js"/>"></script>
</body>
</html>
