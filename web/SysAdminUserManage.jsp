<%-- 
    Document   : SysAdminUserManage
    Created on : 12/05/2021, 8:40:23 PM
    Author     : jesse h
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay System Admin</title>
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
            <h2>User Management</h2>
            
            <%    if (user.getRoleID() == 1) { %>
            
            <div>
            <a href="SysAdminUserAdd.jsp">Create a User</a>
            </div>
                    </div>
                    <br>
                    <!--<table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Password</th>
                                <th>Role ID</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  
                            <c:forEach var="user" items="${listUser}"> <%-- Needs work --%>

                                <tr>
                                    <td>
                                        value="${user.ID}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.phone}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.password}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.role_ID}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${user.ID}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } 
                        </tbody>
                        -->
        </div>
      
         <%}else{%>

         Access Denied! Click <a href="main.jsp">here</a> to go return.

    <%}%>
</div>
</body>
</html>
