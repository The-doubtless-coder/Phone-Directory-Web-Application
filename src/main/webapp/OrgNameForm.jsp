<%--
  Created by IntelliJ IDEA.
  User: wanjalize
  Date: 2/16/25
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <a href="list">Search Contacts By Organization Name</a>
    </h2>
</center>
<div align="center">
    <c:if test="${value == null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${value == 'orgName'}">
        <form action="byorgname" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${value == null}">
                            Edit Contact
                        </c:if>
                        <c:if test="${value == 'orgName'}">
                            Search By Organization Name
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${contact != null}">
                    <input type="hidden" name="id" value="<c:out value='${contact.id}' />" />
                </c:if>
                <tr>
                    <th>Organization Name: </th>
                    <td>
                        <input type="text" name="orgName" size="45"
                               value="<c:out value='${contact.fullName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

