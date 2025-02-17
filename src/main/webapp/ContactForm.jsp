<%--
  Created by IntelliJ IDEA.
  User: wanjalize
  Date: 2/16/25
  Time: 3:33 PM
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
        <a href="list">List All Contacts</a>

    </h2>
</center>
<div align="center">
    <c:if test="${contact != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${contact == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${contact != null}">
                            Edit Contact
                        </c:if>
                        <c:if test="${contact == null}">
                            Add New Contact
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${contact != null}">
                    <input type="hidden" name="id" value="<c:out value='${contact.id}' />" />
                </c:if>
                <tr>
                    <th>FullName: </th>
                    <td>
                        <input type="text" name="fullName" size="45"
                               value="<c:out value='${contact.fullName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>PhoneNumber: </th>
                    <td>
                        <input type="text" name="phoneNumber" size="45"
                               value="<c:out value='${contact.phoneNumber}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${contact.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>IdNumber: </th>
                    <td>
                        <input type="text" name="idNumber" size="45"
                               value="<c:out value='${contact.idNumber}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Date Of Birth: </th>
                    <td>
                        <input type="text" name="dob" size="45"
                               value="<c:out value='${contact.dob}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Gender: </th>
                    <td>
                        <input type="text" name="gender" size="45"
                               value="<c:out value='${contact.gender}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Organization: </th>
                    <td>
                        <input type="text" name="organization" size="45"
                               value="<c:out value='${contact.organization}' />"
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
