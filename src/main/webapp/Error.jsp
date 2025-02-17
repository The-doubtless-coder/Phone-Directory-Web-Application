<%--
  Created by IntelliJ IDEA.
  User: wanjalize
  Date: 2/16/25
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Error</title>
</head>
<body>
<center>
    <h1>Error</h1>
    <h2>${errorMessage}</h2>
    <h2><%=exception.getMessage() %><br/> </h2>
</center>
</body>
</html>