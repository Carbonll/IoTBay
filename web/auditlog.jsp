<%-- 
    Document   : audit log
    Created on : 09/05/2021, 12:06:58 AM
    Author     : melvi
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>

<%@page import="uts.isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Log Page</title>
    </head>
    <%
        User user = (User) session.getAttribute("user");
        ArrayList<Audit> log = (ArrayList<Audit>) session.getAttribute("log");
        String dateErr = (String) session.getAttribute("dateErr");
    %>
    <body>
        <% if (user.getRoleID() == 2) { %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="BrowseServlet">browse</a>
            <a href="addProduct.jsp">Add Product</a>
            <a href="updateProduct.jsp">Update Product</a>
        </div>
        <% } else { %>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="BrowseServlet">browse</a>
        </div>
        <% } %>
        <br>
        <p>Your account access logs are displayed below.</p>
        <form action="AuditServlet">
            <p>Search: <input type="text" name="date" placeholder="dd-mm-yyyy"><input type="submit" value="search"> <%= dateErr != null ? dateErr : ""%></p>
        </form>
        <br>
        <div>
            <table>
                <colgroup>
                    <col span="3" style="width: 100px">
                </colgroup>
                <thead>
                    <tr>
                        <th>Audit ID</th>
                        <th>User ID</th>
                        <th>Event</th>
                        <th>Date/Time</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Audit row : log) {%>
                    <tr>
                        <td style="text-align: center"><%= row.getID()%></td>
                        <td style="text-align: center"><%= row.getUserID()%></td>
                        <td style="text-align: center"><%= row.getEvent()%></td>
                        <td style="text-align: center"><%= row.getDate()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
