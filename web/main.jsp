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
        <title>Main Page</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %> <!--Fetch stored User class, previously created in welcome.jsp-->
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="logout.jsp">logout</a>
            <a href="main.jsp">main</a>
        </div>
        <div>
            <h2>Your current details:</h2>
            <table>
                <tr>
                    <td>Name</td><td>${user.name}</td>
                </tr>
                <tr>
                    <td>Email</td><td>${user.email}</td>
                </tr>
                <tr>
                    <td>Phone</td><td>${user.phone}</td>
                </tr>
                <tr>
                    <td>Password</td><td>${user.password}</td>
                </tr>
            </table>
                <form action="edit.jsp">
                <input type="submit" value="Edit">
            </form>
        </div>
    </body>
</html>
