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
            <h1><a href="index.jsp">IoTBay</a></h1>
            <a href="logout.jsp">logout</a>
            <a href="main.jsp">main</a>
        </div>
        <div>
            <% if (updated == null) { %> <!--Before the Update button is pressed, it is null due to type="hidden", hence it will show the edit form-->
            <form action="edit.jsp" method="post">
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
                <input type="submit" value="Update">
                <input type="hidden" name="updated" value="updated"> 
            </form>
            <% } else { %> <!--Once Update button is pressed, it is no longer null. Execute the below code instead.-->
            <p>Details successfully updated.</p>
            <% } %>
            <%
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");
                user.updateInfo(name, email, phone, password);
            %> <!--Fetch the inputted fields, plug them into the updateInfo() function to update the existing User object/session-->
        </div>
    </body>
</html>
