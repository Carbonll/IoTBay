<%-- 
    Document   : index
    Created on : 17/03/2021, 12:22:28 PM
    Author     : melvi
--%>

<%@page import="uts.isd.model.*"%>

<%@page import="uts.isd.controller.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Account Page</title>
    </head>
    <body>
        <div>
            <h1><a href="index.jsp">IoTBay</a></h1>
        </div>
        <br>
        <div>
            <p>Account successfully deleted. Click <a href="index.jsp">here</a> to return to the home page.</p>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
