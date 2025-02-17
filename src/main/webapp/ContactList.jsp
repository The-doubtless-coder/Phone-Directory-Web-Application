<%--
  Created by IntelliJ IDEA.
  User: wanjalize
  Date: 2/16/25
  Time: 3:38 PM
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
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phone Directory Application</title>
</head>
<body>
<center>
    <h1>Phone Directory Application</h1>
    <h2>
        <a href="new">Add New Contact</a>
        &nbsp;&nbsp;&nbsp;

        <a href="listbyorg">List All By OrgName</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Contacts</h2></caption>
        <tr>
<%--            <th>ID</th>--%>
            <th>FullName</th>
            <th>PhoneNumber</th>
            <th>Email</th>
            <th>IdNumber</th>
            <th>Dob</th>
            <th>Gender</th>
            <th>Organization</th>
            <th>MaskedName</th>
            <th>MaskedPhone</th>
<%--            <th>HashedPhone</th>--%>
            <th>Actions</th>
        </tr>
        <c:forEach var="contact" items="${listContact}">
            <tr>
<%--                <td><c:out value="${contact.id}" /></td>--%>
                <td><c:out value="${contact.fullName}" /></td>
                <td><c:out value="${contact.phoneNumber}" /></td>
                <td><c:out value="${contact.email}" /></td>
                <td><c:out value="${contact.idNumber}" /></td>
                <td><c:out value="${contact.dob}" /></td>
                <td><c:out value="${contact.gender}" /></td>
                <td><c:out value="${contact.organization}" /></td>
                <td><c:out value="${contact.maskedName}" /></td>
                <td><c:out value="${contact.maskedPhone}" /></td>
<%--                <td><c:out value="${contact.hashedPhone}" /></td>--%>
                <td>
                    <a href="edit?id=<c:out value='${contact.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${contact.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
