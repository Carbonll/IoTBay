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
        <title>Register Page</title>
    </head>
    <%
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        String nameErr = (String) session.getAttribute("nameErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
    %>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="login.jsp">login</a>
            <a href="register.jsp">register</a>
        </div>
        <div>
            <form action=RegisterServlet method="post">
                <table>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" placeholder="<%= nameErr != null ? nameErr : "Enter Name"%>" name="name" required></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" placeholder="<%= emailErr != null ? emailErr : "Enter Email"%>" name="email" required></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="text" placeholder="<%= phoneErr != null ? phoneErr : "Enter Phone"%>" name="phone"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" placeholder="<%= passErr != null ? passErr : "Enter Password"%>" name="password" required></td>
                    </tr>
                </table>
                <input type="submit" value="sign up">
            </form>
            <p><%= existErr != null ? existErr : ""%></p>
        </div>
    </body>
</html>
