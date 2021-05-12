<%-- 
    Document   : paymentHistory
    Created on : 12/05/2021, 12:01:24 PM
    Author     : Leon
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.controller.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment History Page</title>
    </head>
    <%
        ArrayList<PaymentHistory> log = (ArrayList<PaymentHistory>) session.getAttribute("log");
        String paymentErr = (String) session.getAttribute("paymentErr");
    %>
    <body>
        <div>
            <h1><a href="main.jsp">IoTBay</a></h1>
            <a href="LogoutServlet">logout</a>
            <a href="main.jsp">main</a>
            <a href="EditServlet">account</a>
            <a href="AuditServlet">access log</a>
            <a href="PaymentHistoryServlet">payment history</a>
        </div>
        <br>
        <p>Your payment history are displayed below.</p>
        <form action="PaymentHistoryServlet">
            <p>Search: <input type="text" name="payment_id" placeholder="Payment ID"><input type="text" name="date" placeholder="dd-mm-yyyy"><input type="submit" value="search"> <%= paymentErr != null ? paymentErr : ""%></p>
        </form>
        <br>
        <div>
            <table>
                <colgroup>
                    <col span="3" style="width: 100px">
                </colgroup>
                <thead>
                    <tr>
                        <th>Payment ID</th>
                        <th>User ID</th>
                        <th>Order ID</th>
                        <th>Payment Date</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (PaymentHistory row : log) {%>
                    <tr>
                        <td style="text-align: center"><%= row.getID()%></td>
                        <td style="text-align: center"><%= row.getUserID()%></td>
                        <td style="text-align: center"><%= row.getOrder()%></td>
                        <td style="text-align: center"><%= row.getDate()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
