<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">Logout</a>
            <a href="main.jsp">Main</a>
            <a href="OrderServlet">Order log</a>
            <a href="EditServlet">Account</a>
            <a href="AuditServlet">Access log</a>
        </div>
        <br>
        <div>
            <h2>Welcome,&nbsp;<%= user.getRoleID() == 2 ? "Staff Member " + user.getName() : user.getRoleID() == 1 ? "System Admin" : user.getName() %></h2>
        </div>
    </body>
</html>
