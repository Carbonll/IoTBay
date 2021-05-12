<%-- 
    Document   : userForm
    Created on : 12/05/2021, 4:53:29 PM
    Author     : jesse h
    This is a page where system admin can manage accounts
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>IoTBay Store </title>
</head>
<body>
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="/new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Users</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${user != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Edit User
                    </c:if>
                    <c:if test="${user == null}">
                        Add New User
                    </c:if>
                </h2>
            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.ID}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="50"
                            value="<c:out value='${user.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="50"
                            value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone: </th>
                <td>
                    <input type="text" name="phone" size="10"
                            value="<c:out value='${user.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="128"
                            value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Role ID: </th>
                <td>
                    <input type="text" name="roleID" size="10"
                            value="<c:out value='${user.role_ID}' />"
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