<%-- 
    Document   : orderMain
    Created on : 10/05/2021, 8:00:05 PM
    Author     : Anthony
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String updated = (String) session.getAttribute("updated");
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
            <p>Your current account details are:</p>
            <form action="UpdateServlet" method="post">
                <input type="hidden" name="ID" value="${user.ID}">
                <table>
                    <tr>
                        <td>Name</td><td><input type="text" name="name" value="${user.name}" required></td>
                    </tr>
                    <tr>
                        <td>Email</td><td><input type="text" name="email" value="${user.email}" required></td>
                    </tr>
                    <tr>
                        <td>Phone</td><td><input type="text" name="phone" value="${user.phone}"></td>
                    </tr>
                    <tr>
                        <td>Password</td><td><input type="text" name="password" value="${user.password}" required></td>
                    </tr>
                </table>
                <p>Please edit the fields above to update any information.</p>
                <p><input type="submit" value="Update"></p>
                <p><a href="deleteAcc.jsp">Delete account</a></p>
            </form>
            <p><%= updated != null ? updated : ""%></p>
        </div>
        <br>
        <div>
            <p>Your current saved payment details are:</p>
        </div>
        <br>
        <div>
            <p>Your current saved shipment details are:</p>
        </div>
    </body>
</html>

