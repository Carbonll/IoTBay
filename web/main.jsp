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
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
        </div>
        <br>
        <div>
            <h2>Welcome,&nbsp;<%= user.getRoleID() == 2 ? "Staff Member " + user.getName() : user.getRoleID() == 1 ? "System Admin" : user.getName() %></h2>
            
            <%    if (user.getRoleID() == 1) { %>
            
            <a href="SysAdminUserAdd.jsp">Create a User</a>
            <a href="SysAdminUserManage.jsp">User Management</a>


        </div>
      
         <%}else{%>

   Whatever the other users will see, regular staff and customers.

    <%}%>
</div>
</body>
</html>
