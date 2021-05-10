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
        ArrayList<Audit> log = (ArrayList<Audit>) session.getAttribute("log");
        String dateErr = (String) session.getAttribute("dateErr");
    %>
    <body>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">Logout</a>
            <a href="main.jsp">Main</a>
            <a href="OrderServlet">Order log</a>
            <a href="EditServlet">Account</a>
            <a href="AuditServlet">Access log</a>
        </div>
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
