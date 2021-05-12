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
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        String nameErr = (String) session.getAttribute("nameErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        String codeErr = (String) session.getAttribute("codeErr"); 
        %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
        </div>
        <br>
        <div>
            <h2>Welcome,&nbsp;<%= user.getRoleID() == 2 ? "Staff Member " + user.getName() : user.getRoleID() == 1 ? "System Admin" : user.getName() %></h2>
        </div>
            <% if (user.getRoleID() == 1){ %>
                    <h2>Add Account</h2>
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
                    <tr>
                        <td>Staff Code</td>
                        <td><input type="text" placeholder="<%= codeErr != null ? codeErr : "Enter Code"%>" name="code"></td>
                    </tr>
                </table>
                <input type="submit" value="Create Account">
            </form>
            <p><%= existErr != null ? existErr : ""%></p>
                    </div>
                    </body>
                    </html>
