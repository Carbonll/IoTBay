<%-- 
    Document   : index
    Created on : 12/05/2021, 12:22:28 PM
    Author     : leon
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Payment Details Page</title>
    </head>
    <%
//        String passErr = (String) session.getAttribute("passErr");
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
        <div>
            <p>Are you sure you want to delete your payment details?</p>
            <form action="DeletePaymentServlet" method="post">
                <input type="submit" value="confirm">
            </form>
        </div>
        <br>
    </body>
</html>
