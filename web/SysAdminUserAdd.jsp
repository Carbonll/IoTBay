<%-- 
    Document   : SysAdminCreate
    Created on : 12/05/2021, 8:40:03 PM
    Author     : jesse h
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay System Admin</title>
    </head>
    <%
        String existErr = (String) session.getAttribute("existErr");
        String emailErr = (String) session.getAttribute("emailErr");
        String passErr = (String) session.getAttribute("passErr");
        String nameErr = (String) session.getAttribute("nameErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        String roleErr = (String) session.getAttribute("roleErr");
    %>
    <body>
        <%
        User user = (User) session.getAttribute("user");
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
            <h2>Create a User</h2>
            
            <%    if (user.getRoleID() == 1) { %>
            
            <div>
            <a href="SysAdminUserManage.jsp">User Management</a>
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
                    <tr>
                        <td>Role ID</td>
                        <td><input type="int" placeholder="<%= roleErr != null ? roleErr : "Enter Role ID"%>" name="roleID" required ></td> <%-- Should this be done by a system admin in a seperate page who could edit to give staff privledges? --%>
                    </tr>
                </table>
                <input type="submit" value="Create User">
            </form>
            <p><%= existErr != null ? existErr : ""%></p>
        </div>

        </div>
      
         <%}else{%>

         Access Denied! Click <a href="main.jsp">here</a> to go return.

    <%}%>
</div>
</body>
</html>
