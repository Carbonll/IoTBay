<%-- 
    Document   : paymentDeleted
    Created on : 12/05/2021, 3:11:11 PM
    Author     : Leon
--%>

<%@page import="uts.isd.model.*"%>

<%@page import="uts.isd.controller.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Payment Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
        </div>
        <br>
        <div>
            <p>Payment details successfully deleted. Click <a href="EditServlet">here</a> to return to the home page.</p>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
