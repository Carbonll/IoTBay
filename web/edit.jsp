<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String updated = request.getParameter("updated");
        %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
        </div>
        <div>
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
                <input type="submit" value="update">
            </form>
            <p><%= updated != null ? updated : ""%></p>
        </div>
    </body>
</html>
