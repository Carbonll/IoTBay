<%-- 
    Document   : SysAdminUserManage
    Created on : 12/05/2021, 8:40:23 PM
    Author     : jesse h
--%>

<%@page import="java.util.List"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.controller.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay System Admin</title>
    </head>
    <body>
        <%
        User user = (User) session.getAttribute("user"); //only used in the intial if statement to check for sysadmin
        
        ArrayList<User> fetchUsers = (ArrayList<User>) session.getAttribute("fetchUsers"); //Check if is the right thing or whether it should call something instead
        String nameErr = (String) session.getAttribute("nameErr");
        String phoneErr = (String) session.getAttribute("phoneErr");
        DBManager manager = (DBManager) session.getAttribute("manager");

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

        <div>
        <form action="UserManageServlet">
            <p>Search User Data Base:<p>
            <table> <!--TBC-->
                <tr><td>Name</td><td><input type="text" name="nameSearch" placeholder="<%= nameErr != null ? nameErr : "Enter Name"%>"></td></tr>
                <tr><td>Phone Number</td><td><input type="text" name="phoneSearch" placeholder="<%= phoneErr != null ? phoneErr : "Enter Phone Number"%>"></td></tr>
                <tr><td><input type="submit" value="Search"></td></tr> 
        </div>
            </table>
        </form>
        <br>
        <div>
            <table>
                <thead>
                        <th>User ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Password</th>
                        <th>Role ID</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (User row:fetchUsers) {%> <!-- Test if result is correct object -->
                    <tr>
                        <td style="text-align: center"><%= row.getID()%></td>
                        <td style="text-align: center"><%= row.getName()%></td>
                        <td style="text-align: center"><%= row.getEmail()%></td>
                        <td style="text-align: center"><%= row.getPhone()%></td>
                        <td style="text-align: center"><%= row.getPassword()%></td>
                        <td style="text-align: center"><%= row.getRoleID()%></td>
                        <td style="text-align: center"><a href="EditUserServlet">Edit</a></td>
                        <td style="text-align: center"><a href="DeleteUserServlet">Delete</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
                
        </div>
    </body>
</html>

<%}else{%>

Access Denied! Click <a href="main.jsp">here</a> to go return.

<%}%>
</div>
</body>
</html>
