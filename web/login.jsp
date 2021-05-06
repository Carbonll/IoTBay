<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="login.jsp">login</a>
            <a href="register.jsp">register</a>
            <form action ="LoginServlet" method ="post">
                <table>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" placeholder="<%= emailErr != null ? emailErr : "Enter Email"%>" name="email" required></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" placeholder="<%= passErr != null ? passErr : "Enter Password"%>" name="password" required></td>
                    </tr>
                </table>
                <input type="submit" value="login">
            </form>
            <p><%= existErr != null ? existErr : ""%></p>
        </div>
    </body>
</html>
