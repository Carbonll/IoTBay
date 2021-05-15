<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
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
        <% if (user.getRoleID() == 2) { %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="BrowseServlet">browse</a>
            <a href="addProduct.jsp">Add Product</a>
            <a href="updateProduct.jsp">Update Product</a>
        </div>
        <% } else { %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="BrowseServlet">browse</a>
        </div>
        <% } %>
        <br>
        <div>
            <h2>Welcome,&nbsp;<%= user.getRoleID() == 2 ? "Staff Member " + user.getName() : user.getRoleID() == 1 ? "System Admin" : user.getName() %></h2>
        </div>
    </body>
</html>
