<%--
    This page is for the system admin to view all user accounts


--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>IoTBay Store</title>
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
<% if (user.getRoleID() == 1){ %>    
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Password</th>
                <th>Role ID</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.ID}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.phone}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.role_ID}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>                     
                </td>
                </tr>
            </c:forEach>
        </table>
    </div>
<%}else{%>
<p>Access Denied! Click <a href="main.jsp">here</a> to go back.</P>
<%}%>
</body>
</html>