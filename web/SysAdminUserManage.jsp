<%-- 
    Document   : SysAdminUserManage
    Created on : 12/05/2021, 8:40:23 PM
    Author     : jesse h
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.dao"%>
<%@page import="uts.isd.controller.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay System Admin</title>
    </head>
    <body>
        <%
        User user = (User) session.getAttribute("user");
        
        ArrayList<User> user = (ArrayList<User>);
        String nameErr = (String) session.getAttribute("nameErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        
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

        <div></div>
        <form action="UserManageServlet">
            <p>Search<p>
            <table>
                <tr><td>Name</td><td><input type="text" name="name" placeholder="<%= nameErr != null ? nameErr : "Enter Name"%>"></td></tr>
                <tr><td>Phone Number</td><td><input type="text" name="phone" placeholder="<%= emailErr != null ? emailErr : "Enter Email"%>"></td></tr>
                <tr><td><input type="submit" value="Search"></td></tr> 

            </table>
        </form>
        <br>
        <div>
            <table>
                <colgroup>
                    <col span="3" style="width: 100px">
                </colgroup>
                <thead>
                        <th>User ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Password</th>
                        <th>Role ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (User row : user) {%>
                    <tr>
                        <td style="text-align: center"><%= row.getUserID()%></td>
                        <td style="text-align: center"><%= row.getName()%></td>
                        <td style="text-align: center"><%= row.getEmail()%></td>
                        <td style="text-align: center"><%= row.getPhone()%></td>
                        <td style="text-align: center"><%= row.getPassword()%></td>
                        <td style="text-align: center"><%= row.getRoleID()%></td>
                        <td style="text-align: center"><a >Edit </a><a > Delete</a></td>>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>

</div>

<%}else{%>

Access Denied! Click <a href="main.jsp">here</a> to go return.

<%}%>
</div>
</body>
</html>
